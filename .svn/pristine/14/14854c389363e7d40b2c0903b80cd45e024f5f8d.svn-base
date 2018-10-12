package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.model.ClinicResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public class ClinicLoaderHelperImpl implements ClinicLoaderHelper {
    private RxUtil rxUtil;
    private EcpAp ecpAp;

    @Inject
    public ClinicLoaderHelperImpl(RxUtil rxUtil, EcpAp ecpAp) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
    }

    @Override
    public Observable<ClinicResponse> getClinic(String cityId) {
        return ecpAp.getClinic(cityId).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<ClinicResponse> getClinicNearMe(String latitude, String longitude) {
        return ecpAp.getClinicNearMe(latitude, longitude).compose(rxUtil.applySchedulers());
    }
}
