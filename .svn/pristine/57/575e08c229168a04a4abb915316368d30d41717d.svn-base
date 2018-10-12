package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.DoctorResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public interface DoctorLoaderHelper {
    Observable<DoctorResponse> getDoctors(String clinicId);

    Observable<List<Doctor>> getDoctors();

    Observable<Boolean> saveDoctors(List<Doctor> doctorList);

    Observable<Boolean> deleteDoctors();

    Observable<List<Doctor>> getSpecialityInDepartment(String deptCode);

    Observable<Doctor> getDoctorById(long id);

}
