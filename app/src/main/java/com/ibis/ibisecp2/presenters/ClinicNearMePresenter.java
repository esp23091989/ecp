package com.ibis.ibisecp2.presenters;

import com.google.android.gms.maps.model.LatLng;
import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.ui.view.ClinicNearMeView;

/**
 * Created by comp on 13.04.17.
 */

public abstract class ClinicNearMePresenter extends BasePresenter<ClinicNearMeView> {
    public abstract void loadClinic(double latitude, double longitude);

    public abstract void loadMyLocation();

    public abstract void loadCity();

    public abstract void loadFavoriteDoctors();

    public abstract void getPatient();

    public abstract void openLocationScreen();

    public abstract void saveLocation(String address, LatLng latLng);

    public abstract void savePatient(Clinic clinic, String clinicId);
}
