package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.ui.view.ListPatientView;

/**
 * Created by comp on 21.03.17.
 */

public abstract class ListPatientPresenter extends BasePresenter<ListPatientView> {
    public abstract void getPatientList();

    public abstract void deletePatient(Patient patient);

    public abstract void onPatientClick(Patient patient);

    public abstract void newPatientLogin();
}
