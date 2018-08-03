package com.ibis.ibisecp2.listeners;

import com.ibis.ibisecp2.model.Patient;

import java.util.ArrayList;

/**
 * Created by danila on 14.06.16.
 */
public interface PatientsHelperGetListener {
    void getPatientsSuccess(ArrayList<Patient> humen);

    void getPatientsError();
}
