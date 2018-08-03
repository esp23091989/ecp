package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.StartPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.InfoActivity;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;

/**
 * Created by danila on 09.08.16.
 */
public class StartPresenterImpl extends StartPresenter {

    private Subscription subscription;
    private SharedPreferencesUtils preferencesUtils;
    private DialogsHelper dialogsHelper;
    private List<Patient> patientList = Collections.emptyList();
    private PatientHelper patientHelper;
    private Navigator navigator;

    @Inject
    public StartPresenterImpl(SharedPreferencesUtils preferencesUtils, DialogsHelper dialogsHelper,
                              PatientHelper patientHelper, Navigator navigator) {
        this.preferencesUtils = preferencesUtils;
        this.dialogsHelper = dialogsHelper;
        this.patientHelper = patientHelper;
        this.navigator = navigator;
    }

    @Override
    public void getPatients() {
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
                    patientList.clear();
                    patientList = patients;
                    view.showPatients(patientList);
                }
            }
        });
    }

    @Override
    public void openMainScreen() {
        navigator.openMainScreen(false);
        navigator.getActivity().finish();
    }

    @Override
    public void openDialogCall() {
        dialogsHelper.createDialogCall();
    }

    @Override
    public void openInfoScreen() {
        navigator.openScreen(InfoActivity.class);
    }

    @Override
    public void start(boolean hasError) {
        if (hasError) {
            savePatient();
        } else {
            startMainActivity();
        }
    }

    private void startMainActivity() {
        if (preferencesUtils.getPatientId() != -1
                && preferencesUtils.getPassword()) {
            openMainScreen();
        } else {
            getPatients();
        }
    }

    @Override
    public void savePatient() {
        preferencesUtils.hasPassword(false);
        view.savePatient();
//        preferencesUtils.savePacient(patient);
//        subscription = patientHelper.savePatient(patient).subscribe(new Observer<Boolean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Boolean aBoolean) {
//                if (isViewAttached()) {
//                    view.savePatient();
//                }
//            }
//        });
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
                if (isViewAttached()) {
                    view.deletePatient();
                }
            }
        });
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    @Override
    public void login() {
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
                    if (patients.isEmpty()) {
                        navigator.openLoginFragment(false);
                    } else {
                        navigator.openListPatientFragment();
                    }
                }
            }
        });
    }

}
