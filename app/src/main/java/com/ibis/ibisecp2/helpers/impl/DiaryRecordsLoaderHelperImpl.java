package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.DiaryRecordsLoaderHelper;
import com.ibis.ibisecp2.model.DiaryRecordsResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 31.10.16.
 */

public class DiaryRecordsLoaderHelperImpl implements DiaryRecordsLoaderHelper {

    private RxUtil rxUtil;
    private EcpAp ecpAp;
    private EncryptUtils encryptUtils;

    @Inject
    public DiaryRecordsLoaderHelperImpl(RxUtil rxUtil, EcpAp ecpAp, EncryptUtils encryptUtils) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
        this.encryptUtils = encryptUtils;
    }

    @Override
    public Observable<DiaryRecordsResponse> getDiaryRecords(String period) {
        return ecpAp.getDiaryRecords(encryptUtils.getToken(), period)
                .compose(rxUtil.applySchedulers());
    }
}
