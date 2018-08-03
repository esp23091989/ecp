package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Visit;

/**
 * Created by comp on 06.04.17.
 */

public interface VisitView {
    void showVisit(Visit visit);

    void hideLoad();

    void cancelVisit();

    void showPatient(Patient patient);

}
