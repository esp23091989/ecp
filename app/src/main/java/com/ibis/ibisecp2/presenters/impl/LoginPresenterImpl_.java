package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.presenters.BasePresenter;
import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.LoginView_;

import javax.inject.Inject;

public class LoginPresenterImpl_ extends BasePresenter<LoginView_> implements LoginPresenter_{

    private final Navigator navigator;

    @Inject
    public LoginPresenterImpl_(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void onStart() {
        navigator.openLoginByEsiaFragment();
    }
}
