package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.CityLoaderHelper;
import com.ibis.ibisecp2.model.CityResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 27.10.16.
 */

public class CityLoaderHelperImpl implements CityLoaderHelper {

    private RxUtil rxUtil;
    private EcpAp ecpAp;

    @Inject
    public CityLoaderHelperImpl(RxUtil rxUtil, EcpAp ecpAp) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
    }

    @Override
    public Observable<CityResponse> getCity() {
        return ecpAp.getCity().compose(rxUtil.applySchedulers());
    }
}
