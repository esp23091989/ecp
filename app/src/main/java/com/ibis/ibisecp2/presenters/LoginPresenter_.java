package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.ui.view.LoginView_;

public abstract class LoginPresenter_ extends BasePresenter<LoginView_> {
    public abstract void onStart();

    public abstract void saveMarker(EsiaTokenMarker marker);
}
