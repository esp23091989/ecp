package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

public class LoginPresenterImpl_ extends LoginPresenter_{

    private final Navigator navigator;
    private final PatientHelper patientHelper;
    private final SharedPreferencesUtils preferencesUtils;

    @Inject
    public LoginPresenterImpl_(Navigator navigator, PatientHelper patientHelper, SharedPreferencesUtils preferencesUtils) {
        this.navigator = navigator;
        this.patientHelper = patientHelper;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void onStart() {
        navigator.openLoginByEsiaFragment();
    }

    @Override
    public void saveMarker(EsiaTokenMarker marker) {
        preferencesUtils.saveEsiaMarker(marker);
    }
}
