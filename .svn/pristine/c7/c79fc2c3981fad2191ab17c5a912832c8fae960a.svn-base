package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.PersonalPresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by comp on 19.04.17.
 */

public class PersonalPresenterImpl extends PersonalPresenter {
    private PatientHelper mPatientHelper;
    private SharedPreferencesUtils preferencesUtils;

    @Inject
    public PersonalPresenterImpl(PatientHelper patientHelper, SharedPreferencesUtils preferencesUtils) {
        mPatientHelper = patientHelper;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void getPatient() {
        unsubscribedSubscription();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .subscribe(new Observer<Patient>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Patient patient) {
                        view.showPatient(patient);
                    }
                });
    }
}
