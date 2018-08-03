package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.events.UpdateDiaryEvent;
import com.ibis.ibisecp2.model.DiaryRecord;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordEditFragment;
import com.ibis.ibisecp2.ui.fragment.EmptyFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by comp on 07.04.17.
 */

public class DiaryPagerActivity extends BaseActivity {
    public static final String EXTRA_DIARY_LIST = "com.ibis.ibisecp2.ui.activity.diary_list";
    public static final String EXTRA_DIARY_POSITION = "com.ibis.ibisecp2.ui.activity.dairy_position";
    public static final String EXTRA_DIARY_RECORD = "com.ibis.ibisecp2.ui.activity.dairy_record";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    @BindView(R.id.viewPagerRegistry)
    ViewPager mViewPager;


    private List<DiaryRecord> diaryRecordList;
    private FragmentStatePagerAdapter statePagerAdapter;

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {
        mViewPager.setVisibility(View.GONE);
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoad() {
        mViewPager.setVisibility(View.VISIBLE);
        mProgressLayout.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry_pager);
        ButterKnife.bind(this);
        setupDrawer();
        toggle.setDrawerIndicatorEnabled(false);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        toggle.syncState();
        setupDiaryPager();
    }

    private void setupDiaryPager() {
        int position = (int) getIntent().getSerializableExtra(EXTRA_DIARY_POSITION);
        diaryRecordList = getIntent().getParcelableArrayListExtra(EXTRA_DIARY_LIST);
        FragmentManager fragmentManager = getSupportFragmentManager();
        statePagerAdapter = new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                if (diaryRecordList.size() == 0) {
                    return new EmptyFragment();
                } else {
                    DiaryRecord diaryRecord = diaryRecordList.get(position);
                    return DiaryRecordEditFragment.newInstance(diaryRecord);
                }

            }

            @Override
            public int getCount() {
                if (diaryRecordList.size() == 0) {
                    return 1;
                } else {
                    return diaryRecordList.size();
                }
            }

        };
        mViewPager.setAdapter(statePagerAdapter);
        mViewPager.setCurrentItem(position);
    }

    public void updateList(DiaryRecord diaryRecord) {
        for (int i = 0; i < diaryRecordList.size(); i++) {
            if (diaryRecordList.get(i).getDate().equals(diaryRecord.getDate())) {
                EventBus.getDefault().postSticky(new UpdateDiaryEvent(diaryRecord, i));
                if (diaryRecord.getNote().equals("")) {
                    diaryRecordList.remove(i);
                }
                break;
            }
        }
        setupDiaryPager();
    }
}
