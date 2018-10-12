package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.TestPostHelper;
import com.ibis.ibisecp2.model.Protocol;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by danila on 03.11.16.
 */

public class TestPostHelperImpl implements TestPostHelper {

    private EcpAp ecpApi;
    private RxUtil rxUtil;

    @Inject
    public TestPostHelperImpl(EcpAp ecpApi, RxUtil rxUtil) {
        this.ecpApi = ecpApi;
        this.rxUtil = rxUtil;
    }

    @Override
    public Observable<ResponseBody> testPost(String empId) {
        return ecpApi.testPost(new Protocol(empId)).compose(rxUtil.applySchedulers());
    }
}
