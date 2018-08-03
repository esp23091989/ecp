package com.ibis.ibisecp2.presenters.impl;

import com.google.android.gms.maps.model.LatLng;
import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.model.ClinicResponse;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.ClinicNearMePresenter;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.LocationActivity;
import com.ibis.ibisecp2.utils.DistanceUtil;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by comp on 13.04.17.
 */

public class ClinicNearMePresenterImpl extends ClinicNearMePresenter {
    /**
     * meters
     */
    private final double RADIUS = 10000;
    private Storage mStorage;
    private RxUtil mRxUtil;
    private SharedPreferencesUtils preferencesUtils;
    private PatientHelper mPatientHelper;
    private DialogsHelper dialogsHelper;
    private Navigator navigator;
    private DistanceUtil mDistanceUtil;
    private ClinicLoaderHelper mClinicLoaderHelper;

    @Inject
    public ClinicNearMePresenterImpl(Storage storage, RxUtil rxUtil,
                                     SharedPreferencesUtils preferencesUtils,
                                     PatientHelper patientHelper, DialogsHelper dialogsHelper,
                                     Navigator navigator, DistanceUtil distanceUtil,
                                     ClinicLoaderHelper clinicLoaderHelper) {
        mStorage = storage;
        mRxUtil = rxUtil;
        this.preferencesUtils = preferencesUtils;
        mPatientHelper = patientHelper;
        this.dialogsHelper = dialogsHelper;
        this.navigator = navigator;
        mDistanceUtil = distanceUtil;
        mClinicLoaderHelper = clinicLoaderHelper;

    }

    @Override
    public void loadClinic(double latitude, double longitude) {
        unsubscribedSubscription();
        subscription = mClinicLoaderHelper.getClinicNearMe(String.valueOf(latitude),
                String.valueOf(longitude)).subscribe(new Observer<ClinicResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    view.error();
                    dialogsHelper.alertDialogErrorMsg(e.getLocalizedMessage());
                }
            }

            @Override
            public void onNext(ClinicResponse clinicResponse) {
                view.showClinic(clinicResponse.getData(), latitude, longitude);
            }
        });
    }

    @Override
    public void loadMyLocation() {
        unsubscribedSubscription();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .subscribe(new Observer<Patient>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.error();
                            dialogsHelper.alertDialogErrorMsg(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onNext(Patient patient) {
                        view.showAddress(patient.getAddress(), patient.getLatLng());
                    }
                });
    }

    @Override
    public void loadCity() {
        navigator.clearBackstack();
        navigator.openCityFragment();
    }

    @Override
    public void loadFavoriteDoctors() {
        navigator.clearBackstack();
        navigator.openDoctorsFavoritesScreen();
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
                        if (isViewAttached()) {
                            view.error();
                            dialogsHelper.alertDialogErrorMsg(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onNext(Patient patient) {
                        if (patient.getAddress() == null) {
                            navigator.openScreen(LocationActivity.class);
                        } else {
                            LatLng latLng = patient.getLatLng();
                            loadClinic(latLng.latitude, latLng.longitude);
                        }
                    }
                });
    }


    @Override
    public void openLocationScreen() {
        unsubscribedSubscription();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .subscribe(new Observer<Patient>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.error();
                            dialogsHelper.alertDialogErrorMsg(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onNext(Patient patient) {
                        if (patient != null && patient.getLatLng() != null) {
                            view.showLocation(patient.getLatLng());
                        } else {
                            view.showLocation(null);
                        }
                    }
                });
    }

    @Override
    public void saveLocation(String address, LatLng latLng) {
        unsubscribedSubscription();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(new Func1<Patient, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Patient patient) {
                        patient.setAddress(address);
                        patient.setLatLng(latLng);
                        return mPatientHelper.savePatient(patient);
                    }
                }).subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.error();
                            dialogsHelper.alertDialogErrorMsg(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (isViewAttached()) {
                            loadClinic(latLng.latitude, latLng.longitude);
//                            view.showAddress(address, latLng);
                        }
                    }
                });
    }

    @Override
    public void savePatient(Clinic clinic, String cityId) {
        if (subscription != null) subscription.unsubscribe();
        preferencesUtils.saveClinicId(clinic.getClinicId().toString());
        preferencesUtils.saveCityId(cityId);
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(new Func1<Patient, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Patient patient) {
                        patient.setClinicId(clinic.getClinicId().toString());
                        patient.setClinicName(clinic.getFullName());
                        patient.setClinicAddress(clinic.getAddress());
                        patient.setClinicPhone(clinic.getPhone());
                        patient.setCityId(cityId);
                        return mPatientHelper.savePatient(patient);
                    }
                }).subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogErrorMsg("Ошибка сохранения пациента");
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
//                        if (isViewAttached()) {
                        navigator.openDoctorFragment(clinic.getClinicId().toString());
//                        }
                    }
                });
    }
}
