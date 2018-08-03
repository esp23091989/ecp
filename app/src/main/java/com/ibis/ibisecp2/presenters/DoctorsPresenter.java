package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.DoctorsView;

/**
 * Created by comp on 31.03.17.
 */

public abstract class DoctorsPresenter extends BasePresenter<DoctorsView> {
    public abstract void loadDoctors(String deptCode);

    public abstract void getDoctors();

    public abstract void openDoctorScreen();

    public abstract void openClinicNearMeScreen();

    public abstract void openDoctorFavorite();

}
