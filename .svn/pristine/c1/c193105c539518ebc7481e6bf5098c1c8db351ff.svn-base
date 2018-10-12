package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.presenters.SpecialityPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by danila on 15.02.17.
 */

public class SpecialityPresenterImpl extends SpecialityPresenter {

    private DialogsHelper dialogsHelper;
    private DoctorLoaderHelper doctorLoaderHelper;
    private Navigator navigator;
    private SharedPreferencesUtils preferencesUtils;
    private PatientHelper mPatientHelper;

    @Inject
    public SpecialityPresenterImpl(DialogsHelper dialogsHelper, DoctorLoaderHelper doctorLoaderHelper,
                                   Navigator navigator, SharedPreferencesUtils preferencesUtils,
                                   PatientHelper patientHelper) {
        this.dialogsHelper = dialogsHelper;
        this.doctorLoaderHelper = doctorLoaderHelper;
        this.navigator = navigator;
        this.preferencesUtils = preferencesUtils;
        mPatientHelper = patientHelper;
    }

    @Override
    public void loadDoctors(String deptCode) {
        if (subscription != null) subscription.unsubscribe();
        view.showLoad();
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
                            view.showDoctors(doctorResponse);
                        }
                    }
                });
    }

    @Override
    public void openDoctors(Doctor doctor) {
        navigator.openDoctorsFragment(doctor.getPositionName(), doctor.getDeptCode());
    }

    @Override
    public void openCityScreen() {
        navigator.clearBackstack();
        navigator.openCityFragment();
    }

    @Override
    public void openDoctorScreen() {
        navigator.clearBackstack();
        navigator.openDoctorsFragment();
    }

    @Override
    public void openClinicScreen() {
        navigator.clearBackstack();
        navigator.openClinicFragment(preferencesUtils.getCityId());
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
