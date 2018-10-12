package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.DoctorsPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by comp on 31.03.17.
 */

public class DoctorsPresenterImpl extends DoctorsPresenter {

    private DialogsHelper dialogsHelper;
    private DoctorLoaderHelper doctorLoaderHelper;
    private Navigator navigator;
    private PatientHelper mPatientHelper;
    private SharedPreferencesUtils preferencesUtils;


    @Inject
    public DoctorsPresenterImpl(DialogsHelper dialogsHelper, DoctorLoaderHelper doctorLoaderHelper,
                                Navigator navigator, PatientHelper patientHelper,
                                SharedPreferencesUtils preferencesUtils) {
        this.dialogsHelper = dialogsHelper;
        this.doctorLoaderHelper = doctorLoaderHelper;
        this.navigator = navigator;
        mPatientHelper = patientHelper;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void loadDoctors(String deptCode) {
        if (subscription != null) subscription.unsubscribe();
        subscription = doctorLoaderHelper.getSpecialityInDepartment(deptCode)
                .subscribe(new Observer<List<Doctor>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.showDoctorsError();
                        }
                    }

                    @Override
                    public void onNext(List<Doctor> doctorResponse) {
                        if (isViewAttached()) {
                            view.showDoctors(doctorResponse, true);
                        }
                    }
                });
    }

    @Override
    public void getDoctors() {
        if (subscription != null) subscription.unsubscribe();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(new Func1<Patient, Observable<List<Doctor>>>() {
                    @Override
                    public Observable<List<Doctor>> call(Patient patient) {
                        view.showPatient(patient);
                        return doctorLoaderHelper.getDoctors();
                    }
                })
                .subscribe(new Observer<List<Doctor>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.showDoctorsError();
                        }
                    }

                    @Override
                    public void onNext(List<Doctor> doctorList) {
                        if (isViewAttached()) {
                            view.showDoctors(doctorList, false);
                        }
                    }
                });
    }

    @Override
    public void openDoctorScreen() {
        navigator.clearBackstack();
        navigator.openDoctorsFragment();
    }

    @Override
    public void openClinicNearMeScreen() {
        navigator.clearBackstack();
        navigator.openClinicNearMeFragment();
    }

    @Override
    public void openDoctorFavorite() {
        navigator.openDoctorsFavoritesScreen();
    }
}
