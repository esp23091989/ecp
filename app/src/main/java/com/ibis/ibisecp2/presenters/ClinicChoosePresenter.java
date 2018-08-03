package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.ui.view.ClinicChooseView;

/**
 * Created by danila on 03.08.16.
 */
public abstract class ClinicChoosePresenter extends BasePresenter<ClinicChooseView> {
    public abstract void loadClinic(String cityId);

    public abstract void getLccation();

    public abstract void savePatient(Clinic clinic, String clinicId);

    public abstract void openClinicNearMeFragment();

    public abstract void openCityFragment();

    public abstract void openFavoriteDoctors();


}
