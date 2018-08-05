package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 20.10.16.
 */

public class AuthHelperImpl implements AuthHelper {

    private RxUtil rxUtil;
    private EcpAp api;
//    private EisaApi eisaApi;
    private EncryptUtils encryptUtils;

    @Inject
    public AuthHelperImpl(EcpAp api, RxUtil rxUtil, EncryptUtils encryptUtils) {
        this.api = api;
        this.rxUtil = rxUtil;
        this.encryptUtils = encryptUtils;
    }

    @Override
    public Observable<AuthResponse> auth(String login, String password, String idType) {
        return api.auth(encryptUtils.encryptLogin(login, password, idType))
                .compose(rxUtil.applySchedulers());
    }
}
