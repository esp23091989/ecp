package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.ui.view.DoctorView;

/**
 * Created by danila on 15.02.17.
 */

public abstract class SpecialityPresenter extends BasePresenter<DoctorView> {
    public abstract void loadDoctors(String deptCode);

    public abstract void openDoctors(Doctor doctor);

    public abstract void openCityScreen();

    public abstract void openDoctorScreen();

    public abstract void openClinicScreen();

    public abstract void openClinicNearMeScreen();

    public abstract void openDoctorFavorite();

}
