package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.listeners.ChooseDoctorListener;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.presenters.AppointmentPresenter;
import com.ibis.ibisecp2.ui.view.AppointmentView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppointmentActivity extends BaseActivity implements AppointmentView, ChooseDoctorListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contentFrame)
    FrameLayout contentFrame;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    AppointmentPresenter appointmentPresenter;
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;

    private Doctor doctor;

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {
        contentFrame.setVisibility(View.GONE);
        mProgressLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoad() {
        contentFrame.setVisibility(View.VISIBLE);
        mProgressLayout.setVisibility(View.GONE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ButterKnife.bind(this);
        appointmentPresenter.attachView(this);
        setTitle(getString(R.string.title_appointment));
        setupDrawer();
        if (preferencesUtils.getCityId() != null && preferencesUtils.getClinicId() != null) {
            appointmentPresenter.openDoctorFragment("");
        } else {
            appointmentPresenter.openCityScreen();
        }

    }

    @Override
    protected void onResume() {
        preferencesUtils.saveItemId(R.id.nav_appointment);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        appointmentPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onDoctorClick(Doctor doctor) {
        this.doctor = doctor;
    }
}
