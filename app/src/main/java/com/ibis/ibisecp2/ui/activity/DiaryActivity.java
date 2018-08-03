package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiaryActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @Inject
    Navigator navigator;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    @BindView(R.id.contentFrame)
    FrameLayout mContentFrame;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {
        mContentFrame.setVisibility(View.GONE);
        mProgressLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoad() {
        mContentFrame.setVisibility(View.VISIBLE);
        mProgressLayout.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ButterKnife.bind(this);
        setTitle(getString(R.string.title_diary));
        setupDrawer();
        navigator.openDiaryFragment();
    }

    @Override
    protected void onResume() {
        preferencesUtils.saveItemId(R.id.nav_diary);
        super.onResume();
    }
}
