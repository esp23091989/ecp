package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.DoctorResponse;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.DepartmentPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by danila on 02.11.16.
 */

public class DepartmentPresenterImpl extends DepartmentPresenter {

    private DialogsHelper dialogsHelper;
    private DoctorLoaderHelper doctorLoaderHelper;
    private Navigator navigator;
    private SharedPreferencesUtils preferencesUtils;
    private PatientHelper mPatientHelper;
    private RxUtil mRxUtil;
    private List<Doctor> doctorList;

    @Inject
    public DepartmentPresenterImpl(DialogsHelper dialogsHelper, DoctorLoaderHelper doctorLoaderHelper,
                                   Navigator navigator,
                                   SharedPreferencesUtils preferencesUtils, RxUtil rxUtil,
                                   PatientHelper patientHelper) {
        this.doctorLoaderHelper = doctorLoaderHelper;
        this.dialogsHelper = dialogsHelper;
        this.navigator = navigator;
        this.preferencesUtils = preferencesUtils;
        mRxUtil = rxUtil;
        mPatientHelper = patientHelper;
    }

    @Override
    public void loadFromInet(String id) {
        if ("".equals(id)) {
            id = preferencesUtils.getClinicId();
        }
        if (subscription != null) subscription.unsubscribe();
        subscription = doctorLoaderHelper.getDoctors(id)
                .compose(mRxUtil.applySchedulers())
                .flatMap(new Func1<DoctorResponse, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(DoctorResponse doctorResponse) {
                        doctorList = doctorResponse.getDoctorList();
                        for (int i = 0; i < doctorList.size(); i++) {
                            doctorList.get(i).set_id(Long
                                    .parseLong(doctorList.get(i).getSnils()));
                        }
                        return doctorLoaderHelper.deleteDoctors();
                    }
                })
                .flatMap(new Func1<Boolean, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Boolean aBoolean) {
                        view.showDoctors(doctorList);
                        return doctorLoaderHelper.saveDoctors(doctorList);
                    }
                })
                .subscribe(new Observer<Boolean>() {
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
                    public void onNext(Boolean aBoolean) {
                    }
                });
    }

    @Override
    public void openSpecialityScreen(String deptCode) {
        navigator.openSpecialityFragment(deptCode);
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
    public void openClinicNearMeScreen() {
        navigator.clearBackstack();
        navigator.openClinicNearMeFragment();
    }

    @Override
    public void openClinicScreen() {
        navigator.clearBackstack();
        navigator.openClinicFragment(preferencesUtils.getCityId());
    }

    @Override
    public void openDoctorFavorite() {
        navigator.clearBackstack();
        navigator.openDoctorsFavoritesScreen();
    }

    @Override
    public void savePatient() {

    }

    @Override
    public void getPatient() {
        if (subscription != null) subscription.unsubscribe();
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
