package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.TasksHelper;
import com.ibis.ibisecp2.model.Tasks;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 14.12.16.
 */

public class TasksHelperImpl implements TasksHelper {

    private EcpAp ecpApi;
    private RxUtil rxUtil;
    private EncryptUtils encryptUtils;

    @Inject
    public TasksHelperImpl(EcpAp ecpApi, RxUtil rxUtil, EncryptUtils encryptUtils) {
        this.ecpApi = ecpApi;
        this.rxUtil = rxUtil;
        this.encryptUtils = encryptUtils;
    }

    @Override
    public Observable<Tasks> getTasks() {
        return ecpApi.getTasks(encryptUtils.getToken()).compose(rxUtil.applySchedulers());
    }
}
