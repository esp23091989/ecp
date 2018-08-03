package com.ibis.ibisecp2.presenters.impl;

import com.google.android.gms.location.places.Place;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.LocationPresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by comp on 17.04.17.
 */

public class LocationPresenterImpl extends LocationPresenter {
    private PatientHelper mPatientHelper;
    private SharedPreferencesUtils preferencesUtils;

    @Inject
    public LocationPresenterImpl(PatientHelper patientHelper,
                                 SharedPreferencesUtils preferencesUtils) {
        mPatientHelper = patientHelper;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void saveLocation(Place place) {
        unsubscribedSubscription();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(new Func1<Patient, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Patient patient) {
                        patient.setAddress(place.getAddress().toString());
                        patient.setLatLng(place.getLatLng());
                        return mPatientHelper.savePatient(patient);
                    }
                }).subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.error();
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        view.saveLocation();
                    }
                });
    }

    @Override
    public void getLocation() {
        unsubscribedSubscription();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .subscribe(new Observer<Patient>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.error();
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
}
