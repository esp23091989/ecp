package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.ServiceRenderedLoaderHelper;
import com.ibis.ibisecp2.model.SvedMu;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 31.10.16.
 */

public class ServiceRenderedLoaderHelperImpl implements ServiceRenderedLoaderHelper {
    private RxUtil rxUtil;
    private EcpAp ecpAp;
    private EncryptUtils encryptUtils;

    @Inject
    public ServiceRenderedLoaderHelperImpl(RxUtil rxUtil, EcpAp ecpAp, EncryptUtils encryptUtils) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
        this.encryptUtils = encryptUtils;
    }

//    @Override
//    public Observable<SvedMuResponse> getSvedMu(String login, String fromDate, String toDate) {
//        return ecpAp.getTime().flatMap(new Func1<CurrentTime, Observable<SvedMuResponse>>() {
//            @Override
//            public Observable<SvedMuResponse> call(CurrentTime currentTime) {
//                return ecpAp.getSvedMu(login, encryptUtils.getToken(currentTime.getCurrentTime()),
//                        fromDate, toDate);
//            }
//        }).compose(rxUtil.applySchedulers());
//    }

    @Override
    public Observable<SvedMu> getSvedMu(String fromDate, String toDate) {
        return ecpAp.getSvedMu(encryptUtils.getToken(), fromDate, toDate)
                .compose(rxUtil.applySchedulers());
    }
}
