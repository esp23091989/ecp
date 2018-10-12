package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.LocationHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.model.ClinicResponse;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.ClinicChoosePresenter;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by danila on 03.08.16.
 */
public class ClinicChoosePresenterImpl extends ClinicChoosePresenter {
    private DialogsHelper dialogsHelper;
    private SharedPreferencesUtils preferencesUtils;
    private PatientHelper patientHelper;
    private ClinicLoaderHelper clinicLoaderHelper;
    private Navigator navigator;
    private LocationHelper locationHelper;
    private String cityId;
    private Storage mStorage;
    private List<Clinic> mClinicList = new ArrayList<>();

    @Inject
    public ClinicChoosePresenterImpl(DialogsHelper dialogsHelper,
                                     SharedPreferencesUtils preferencesUtils,
                                     PatientHelper patientHelper,
                                     ClinicLoaderHelper clinicLoaderHelper, Navigator navigator,
                                     LocationHelper locationHelper,
                                     Storage mStorage) {
        this.dialogsHelper = dialogsHelper;
        this.preferencesUtils = preferencesUtils;
        this.patientHelper = patientHelper;
        this.clinicLoaderHelper = clinicLoaderHelper;
        this.navigator = navigator;
        this.locationHelper = locationHelper;
        this.mStorage = mStorage;
    }

    @Override
    public void loadClinic(String cityId) {
        this.cityId = cityId;
//
        if (subscription != null) subscription.unsubscribe();
        subscription = patientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(patient -> {
                    view.setupCity(patient.getCityName());
                    return clinicLoaderHelper.getClinic(cityId);
                })
                .flatMap((Func1<ClinicResponse, Observable<Boolean>>) clinicResponse -> {
                    mClinicList.clear();
                    if (clinicResponse != null && clinicResponse.getData() != null) {
                        mClinicList.addAll(clinicResponse.getData());
                    }
                    return mStorage.saveItemInDb(clinicResponse);
                })
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.showClinicError();
                            locationHelper.stopUsingGPS();
                        }
                    }

                    @Override
                    public void onNext(Boolean response) {
                        if (isViewAttached()) {
                            view.showClinic(mClinicList);
                        }
                    }
                });
    }

    @Override
    public void getLccation() {
        locationHelper.getLoc();
    }

    @Override
    public void savePatient(Clinic clinic, String cityId) {
        if (subscription != null) subscription.unsubscribe();
        preferencesUtils.saveClinicId(clinic.getClinicId().toString());
        preferencesUtils.saveCityId(cityId);
        subscription = patientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(new Func1<Patient, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Patient patient) {
                        patient.setClinicId(clinic.getClinicId().toString());
                        patient.setClinicName(clinic.getFullName());
                        patient.setClinicAddress(clinic.getAddress());
                        patient.setClinicPhone(clinic.getPhone());
                        patient.setCityId(cityId);
                        return patientHelper.savePatient(patient);
                    }
                })
                .subscribe(new Observer<Boolean>() {
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
                        if (isViewAttached()) {
                            navigator.openDoctorFragment(clinic.getClinicId().toString());
                        }
                    }
                });
    }

    @Override
    public void openClinicNearMeFragment() {
        navigator.clearBackstack();
        navigator.openClinicNearMeFragment();
    }

    @Override
    public void openCityFragment() {
        navigator.clearBackstack();
        navigator.openCityFragment();
    }

    @Override
    public void openFavoriteDoctors() {
        navigator.clearBackstack();
        navigator.openDoctorsFavoritesScreen();
    }
}
