package com.ibis.ibisecp2.presenters.impl;

import android.util.Log;

import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.ui.Navigator;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

public class LoginPresenterImpl_ extends LoginPresenter_{

    private final Navigator navigator;
    private final PatientHelper patientHelper;

    @Inject
    public LoginPresenterImpl_(Navigator navigator, PatientHelper patientHelper) {
        this.navigator = navigator;
        this.patientHelper = patientHelper;
    }

    @Override
    public void onStart(boolean hasError) {
        if(!hasError){
            subscription = patientHelper.getPatientList().subscribe(patients -> {
                if(isViewAttached() && !patients.isEmpty())
                    view.openPatientList(false);
            });
        }
//        navigator.openLoginByEsiaFragment();
    }
}
