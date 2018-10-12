package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.DoctorResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public class DoctorLoaderHelperImpl implements DoctorLoaderHelper {

    private RxUtil rxUtil;
    private EcpAp ecpAp;
    private Storage storage;

    @Inject
    public DoctorLoaderHelperImpl(RxUtil rxUtil, EcpAp ecpAp, Storage storage) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
        this.storage = storage;
    }

    @Override
    public Observable<DoctorResponse> getDoctors(String clinicId) {
        return ecpAp.getSpecialist(clinicId);
    }

    @Override
    public Observable<List<Doctor>> getDoctors() {
        return storage.getArrayListFromDb(Doctor.class).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> saveDoctors(List<Doctor> doctorList) {
        return storage.saveArrayListInDb(doctorList);
    }

    @Override
    public Observable<Boolean> deleteDoctors() {
        return storage.deleteArrayListFromDb(Doctor.class);
    }

    @Override
    public Observable<List<Doctor>> getSpecialityInDepartment(String deptCode) {
        return storage.getDocByDepartment(deptCode).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Doctor> getDoctorById(long id) {
        return storage.getObjectById(Doctor.class, id);
    }
}
