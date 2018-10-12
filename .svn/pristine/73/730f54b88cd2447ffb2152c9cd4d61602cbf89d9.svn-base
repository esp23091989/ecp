package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.presenters.AppointmentPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

/**
 * Created by danila on 02.11.16.
 */

public class AppointmentPresenterImpl extends AppointmentPresenter {

    private Navigator navigator;
    private SharedPreferencesUtils preferencesUtils;

    @Inject
    public AppointmentPresenterImpl(Navigator navigator, SharedPreferencesUtils preferencesUtils) {
        this.navigator = navigator;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void openDoctorFragment(String clinicId) {
        navigator.openDoctorFragment(clinicId);
    }

    @Override
    public void openCityScreen() {
        navigator.openCityFragment();
    }
}
