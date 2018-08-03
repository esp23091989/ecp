package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.ClinicResponse;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public interface ClinicLoaderHelper {
    Observable<ClinicResponse> getClinic(String cityId);

    Observable<ClinicResponse> getClinicNearMe(String latitude, String longitude);
}
