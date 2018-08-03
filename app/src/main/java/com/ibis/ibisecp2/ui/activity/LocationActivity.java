package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.ui.Navigator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationActivity extends BaseActivity {
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    @BindView(R.id.contentFrame)
    FrameLayout mContentFrame;


    @Inject
    Navigator navigator;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ButterKnife.bind(this);
        setTitle(getString(R.string.title_location));
        setupDrawer();
        navigator.openLocationFragment();
        hideLoad();
    }


}
