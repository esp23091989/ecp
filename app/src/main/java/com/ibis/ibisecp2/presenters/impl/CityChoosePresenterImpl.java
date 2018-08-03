package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.CityLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.CityResponse;
import com.ibis.ibisecp2.presenters.CityChoosePresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by danila on 03.08.16.
 */
public class CityChoosePresenterImpl extends CityChoosePresenter {

    private DialogsHelper dialogsHelper;
    private SharedPreferencesUtils preferencesUtils;
    private CityLoaderHelper cityLoaderHelper;
    private PatientHelper patientHelper;
    private Navigator navigator;

    @Inject
    public CityChoosePresenterImpl(DialogsHelper dialogsHelper, CityLoaderHelper cityLoaderHelper,
                                   SharedPreferencesUtils preferencesUtils,
                                   PatientHelper patientHelper, Navigator navigator) {

        this.dialogsHelper = dialogsHelper;
        this.cityLoaderHelper = cityLoaderHelper;
        this.preferencesUtils = preferencesUtils;
        this.patientHelper = patientHelper;
        this.navigator = navigator;
    }

    @Override
    public void loadCity() {
        if (subscription != null) subscription.unsubscribe();
        subscription = cityLoaderHelper.getCity().subscribe(new Observer<CityResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    dialogsHelper.alertDialogError(e);
                    view.showCityError();
                }
            }

            @Override
            public void onNext(CityResponse cityResponse) {
                if (isViewAttached()) {
                    view.showCity(cityResponse.getCityList());
                }
            }
        });
    }

    @Override
    public void openClinicScreen(String idCity, String cityName) {
        if (subscription != null) subscription.unsubscribe();
        subscription = patientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(patient -> {
                    patient.setCityName(cityName);
                    return patientHelper.savePatient(patient);
                }).subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.showCityError();
                        }
                    }

                    @Override
                    public void onNext(Boolean patient) {
                        if (isViewAttached()) {
                            navigator.openClinicFragment(idCity);
                        }
                    }
                });
    }

    @Override
    public void openClinicNearMeScreen() {
        navigator.openClinicNearMeFragment();
    }

    @Override
    public void openFavoriteDoctors() {
        navigator.openDoctorsFavoritesScreen();
    }
}
