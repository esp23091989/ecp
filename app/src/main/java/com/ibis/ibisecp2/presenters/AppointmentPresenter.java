package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.AppointmentView;

/**
 * Created by danila on 02.11.16.
 */

public abstract class AppointmentPresenter extends BasePresenter<AppointmentView> {

    public abstract void openDoctorFragment(String clinicId);

    public abstract void openCityScreen();
}
