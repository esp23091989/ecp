package com.ibis.ibisecp2.presenters.impl;

import android.util.Log;

import com.ibis.ibisecp2.events.NewPatientrRegistredEvent;
import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.Child;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Warning;
import com.ibis.ibisecp2.presenters.LoginByEsiaPresenter;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.SingleSubscriber;
import rx.functions.Func1;

public class LoginByEsiaPresenterImpl extends LoginByEsiaPresenter {

    private final SharedPreferencesUtils preferencesUtils;
    private final AuthHelper authHelper;
    private final RxUtil rxUtil;
    private final PatientHelper patientHelper;

    private EsiaTokenMarker marker;

    @Inject
    public LoginByEsiaPresenterImpl(
            SharedPreferencesUtils sharedPreferencesUtils,
            AuthHelper authHelper,
            RxUtil rxUtil,
            PatientHelper patientHelper) {
        this.preferencesUtils = sharedPreferencesUtils;
        this.authHelper = authHelper;
        this.rxUtil = rxUtil;
        this.patientHelper = patientHelper;
    }

    @Override
    public void saveEsiaMarker(EsiaTokenMarker marker) {
        preferencesUtils.saveEsiaMarker(marker);
        this.marker = marker;
    }
}
