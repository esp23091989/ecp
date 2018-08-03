package com.ibis.ibisecp2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.events.CancelVisit;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment;
import com.ibis.ibisecp2.ui.fragment.RemembersFragment;
import com.ibis.ibisecp2.ui.fragment.ReminderHistoryFragment;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 24.11.15.
 */
public class RegistryActivity extends BaseActivity {

    public static final String ARG_ID = "id";

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    private ViewPagerAdapter adapter;

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {
        viewPager.setVisibility(View.GONE);
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoad() {
        viewPager.setVisibility(View.VISIBLE);
        mProgressLayout.setVisibility(View.GONE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        ButterKnife.bind(this);
        setTitle(getString(R.string.title_cartulary));
        setupDrawer();
        int id = -1;
        if (getIntent().hasExtra(ARG_ID)) {
            id = getIntent().getIntExtra(ARG_ID, -1);
        }
        setupViewPager(viewPager, id);
        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor((ContextCompat.getColor(this, R.color.white)));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                AndroidUtils.hideKeyboard(getCurrentFocus());
            }
        });
    }

    @Override
    protected void onResume() {
        preferencesUtils.saveItemId(R.id.nav_cartulary);
        super.onResume();
    }

    private void setupViewPager(ViewPager viewPager, int id) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(RemembersFragment.newInstance(id),
                getString(R.string.diary_tab_remembers));
        adapter.addFragment(new ReminderHistoryFragment(),
                getString(R.string.diary_tab_history));
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            ((DiaryRecordsFragment) adapter.getFragment(1)).updateRecords();
            if (data == null) {
                return;
            }
            String txt = data.getStringExtra("msg");
            dialogsHelper.alertDialogErrorMsg(txt);
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public Fragment getFragment(int position) {
            return mFragmentList.get(position);
        }

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(0);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(sticky = true)
    public void onCancelVisitEvent(CancelVisit event) {
        EventBus.getDefault().removeStickyEvent(event);
        dialogsHelper.alertDialogErrorMsg("Запись на прием отменена");
    }
}
