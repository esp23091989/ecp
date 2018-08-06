package com.ibis.ibisecp2.presenters.impl;

import android.util.Log;

import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.presenters.LoginByEsiaPresenter;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observer;
import rx.SingleSubscriber;

public class LoginByEsiaPresenterImpl extends LoginByEsiaPresenter {

    private final SharedPreferencesUtils sharedPreferencesUtils;
    private final AuthHelper authHelper;
    private final RxUtil rxUtil;
    private EsiaTokenMarker marker;

    @Inject
    public LoginByEsiaPresenterImpl(
            SharedPreferencesUtils sharedPreferencesUtils,
            AuthHelper authHelper,
            RxUtil rxUtil) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
        this.authHelper = authHelper;
        this.rxUtil = rxUtil;
    }

    @Override
    public void saveEsiaMarker(EsiaTokenMarker marker) {
        sharedPreferencesUtils.saveEsiaMarker(marker);
        this.marker = marker;
    }

    @Override
    public void getPatient() {
        authHelper.auth(marker)
                .compose(rxUtil.schedulers())
                .subscribe(new SingleSubscriber<AuthResponse>() {
                    @Override
                    public void onSuccess(AuthResponse authResponse) {
                        Log.d("","");
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.d("", "");
                    }
                });
    }
}
