package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.ListPatientPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.LoginActivity;
import com.ibis.ibisecp2.ui.activity.StartActivity;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by comp on 21.03.17.
 */

public class ListPatientPresenterImpl extends ListPatientPresenter {

    private PatientHelper patientHelper;
    private SharedPreferencesUtils preferencesUtils;
    private Navigator navigator;

    @Inject
    public ListPatientPresenterImpl(SharedPreferencesUtils preferencesUtils, Navigator navigator,
                                    PatientHelper patientHelper) {
        this.preferencesUtils = preferencesUtils;
        this.navigator = navigator;
        this.patientHelper = patientHelper;
    }


    @Override
    public void getPatientList() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        subscription = patientHelper.getPatientList().subscribe(new Observer<List<Patient>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Patient> patients) {
                if (isViewAttached()) {

                    view.showListPatient(patients);
                }
            }
        });

    }

    @Override
    public void deletePatient(Patient patient) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        subscription = patientHelper.deletePatient(patient).subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                preferencesUtils.deleteCityId();
                preferencesUtils.deleteClinicId();
                preferencesUtils.hasPassword(false);
                preferencesUtils.savePatientId(-1);
                getPatientList();
            }
        });
    }

    @Override
    public void onPatientClick(Patient patient) {
        preferencesUtils.hasPassword(true);
        preferencesUtils.saveSnils(patient.getSNILS());
        preferencesUtils.savePatientId(patient.get_id());
        preferencesUtils.saveClinicId(patient.getClinicId());
        preferencesUtils.saveCityId(patient.getCityId());
        navigator.openMainScreen(true);
        navigator.getActivity().finish();
    }

    @Override
    public void newPatientLogin() {
        navigator.openScreenForResult(LoginActivity.class, StartActivity.REQUEST_CODE_ESIA_MARKER);
    }
}
