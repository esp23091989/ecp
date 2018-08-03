package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.Patient;

import java.util.List;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public interface PatientHelper {
    Observable<Boolean> savePatient(Patient patient);

    Observable<Boolean> savePatientList(List<Patient> patientList);

    Observable<Boolean> deletePatient(Patient patient);

    Observable<Patient> getPatient(Patient patient);

    Observable<Patient> getPatient(long id);

    Observable<List<Patient>> getPatientList();
}
