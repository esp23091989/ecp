package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.ConfirmCodeHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by comp on 21.03.17.
 */

public class ConfirmCodeHelperImpl implements ConfirmCodeHelper {
    private RxUtil rxUtil;
    private EcpAp api;
    private EncryptUtils encryptUtils;

    @Inject
    public ConfirmCodeHelperImpl(EcpAp api, RxUtil rxUtil, EncryptUtils encryptUtils) {
        this.api = api;
        this.rxUtil = rxUtil;
        this.encryptUtils = encryptUtils;
    }

    @Override
    public Observable<AuthResponse> confirm(String login, String password, String idType) {
        return null;
    }
}
