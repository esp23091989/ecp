package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.presenters.RegistryPagerPresenter;
import com.ibis.ibisecp2.ui.fragment.EmptyFragment;
import com.ibis.ibisecp2.ui.fragment.VisitFragment;
import com.ibis.ibisecp2.ui.view.RegistryPagerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistryPagerActivity extends BaseActivity implements RegistryPagerView {
    //caseNumber
    public static final String EXTRA_VISIT_CASE_NUMBER = "com.ibis.ibisecp2.ui.activity.case_number";
    public static final String EXTRA_IS_HISTORY = "com.ibis.ibisecp2.ui.activity.is_history";


    @Inject
    RegistryPagerPresenter mRegistryPagerPresenter;
    @Inject
    DialogsHelper dialogsHelper;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    @BindView(R.id.viewPagerRegistry)
    ViewPager mViewPagerRegistry;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    private List<Visit> visitList;

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {
        mViewPagerRegistry.setVisibility(View.GONE);
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoad() {
        mViewPagerRegistry.setVisibility(View.VISIBLE);
        mProgressLayout.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry_pager);
        ButterKnife.bind(this);
        setTitle(getString(R.string.title_appointment));
        setupDrawer();
        mRegistryPagerPresenter.attachView(this);
        mRegistryPagerPresenter.loadVisits((boolean) getIntent().getSerializableExtra(EXTRA_IS_HISTORY));

        toggle.setDrawerIndicatorEnabled(false);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        toggle.syncState();
    }

    @Override
    public void showVisits(List<Visit> visitList) {
        hideLoad();
        this.visitList = visitList;
        boolean isHistory = (boolean) getIntent().getSerializableExtra(EXTRA_IS_HISTORY);
        String caseNumber = (String) getIntent().getSerializableExtra(EXTRA_VISIT_CASE_NUMBER);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentStatePagerAdapter fragmentPagerAdapter = new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                if (visitList.size() == 0) {
                    return new EmptyFragment();
                } else {
                    Visit visit = visitList.get(position);
                    return VisitFragment.newInstance(visit.getCaseNumber(), isHistory);
                }

            }

            @Override
            public int getCount() {
                if (visitList.size() == 0) {
                    return 1;
                } else {
                    return visitList.size();
                }
            }

        };
        mViewPagerRegistry.setAdapter(fragmentPagerAdapter);

        for (int i = 0; i < visitList.size(); i++) {
            if (visitList.get(i).getCaseNumber().equals(caseNumber)) {
                mViewPagerRegistry.setCurrentItem(i);
                break;
            }
        }

    }


    @Override
    protected void onDestroy() {
        mRegistryPagerPresenter.detachView();
        super.onDestroy();
    }
}
