package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.DoctorView;

/**
 * Created by danila on 02.11.16.
 */

public abstract class DepartmentPresenter extends BasePresenter<DoctorView> {

    public abstract void loadFromInet(String clinicId);

    public abstract void openSpecialityScreen(String deptCode);

    public abstract void openCityScreen();

    public abstract void openDoctorScreen();

    public abstract void openClinicNearMeScreen();

    public abstract void openClinicScreen();

    public abstract void openDoctorFavorite();

    public abstract void savePatient();

    public abstract void getPatient();
}
