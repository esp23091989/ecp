package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public class PatientHelperImpl implements PatientHelper {
    private Storage cupboard;
    private RxUtil rxUtil;

    @Inject
    public PatientHelperImpl(Storage cupboard, RxUtil rxUtil) {
        this.cupboard = cupboard;
        this.rxUtil = rxUtil;
    }

    @Override
    public Observable<Boolean> savePatient(Patient patient) {
        return cupboard.saveItemInDb(patient).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> savePatientList(List<Patient> patientList) {
        return cupboard.saveArrayListInDb(patientList)
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> deletePatient(Patient patient) {
        return cupboard.deleteObjectById(Patient.class, patient.get_id())
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Patient> getPatient(Patient patient) {
        return cupboard.getObjectById(Patient.class, patient.get_id())
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Patient> getPatient(long id) {
        return cupboard.getObjectById(Patient.class, id)
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<List<Patient>> getPatientList() {
        return cupboard.getArrayListFromDb(Patient.class).compose(rxUtil.applySchedulers());
    }
}
