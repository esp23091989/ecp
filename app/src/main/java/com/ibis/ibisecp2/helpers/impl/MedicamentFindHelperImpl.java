package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.MedicamentFindHelper;
import com.ibis.ibisecp2.model.MedicamentResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public class MedicamentFindHelperImpl implements MedicamentFindHelper {

    private RxUtil rxUtil;
    private EcpAp ecpAp;

    @Inject
    public MedicamentFindHelperImpl(RxUtil rxUtil, EcpAp ecpAp) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
    }

    @Override
    public Observable<MedicamentResponse> findMedicament(String name) {
        return ecpAp.findMedicament(name).compose(rxUtil.applySchedulers());
    }
}
