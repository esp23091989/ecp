package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.ui.fragment.ServiceRenderedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 28.06.16.
 */
public class ServiceRenderedActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    @BindView(R.id.contentFrame)
    FrameLayout mContentFrame;

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
        setTitle(getString(R.string.title_service_rendered));
        setupDrawer();
        if (savedInstanceState == null) {
            ServiceRenderedFragment fragment = new ServiceRenderedFragment();
            String tag = fragment.getClass().getSimpleName();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFrame, fragment, tag)
                    .addToBackStack(tag)
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        preferencesUtils.saveItemId(R.id.nav_my_services);
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
