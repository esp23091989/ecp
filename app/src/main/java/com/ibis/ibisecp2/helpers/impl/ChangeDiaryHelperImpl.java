package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.ChangeDiaryHelper;
import com.ibis.ibisecp2.model.ErrorResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 08.12.16.
 */

public class ChangeDiaryHelperImpl implements ChangeDiaryHelper {

    private EcpAp ecpApi;
    private RxUtil rxUtil;
    private EncryptUtils encryptUtils;

    @Inject
    public ChangeDiaryHelperImpl(EcpAp ecpApi, RxUtil rxUtil, EncryptUtils encryptUtils) {
        this.ecpApi = ecpApi;
        this.rxUtil = rxUtil;
        this.encryptUtils = encryptUtils;
    }

    @Override
    public Observable<ErrorResponse> changeDiary(String note, String noteDate) {
        return ecpApi.changeDiary(encryptUtils.getToken(), note, noteDate)
                .compose(rxUtil.applySchedulers());
    }
}
