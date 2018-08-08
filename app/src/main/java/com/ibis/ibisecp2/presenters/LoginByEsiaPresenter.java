package com.ibis.ibisecp2.presenters;


import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.ui.view.LoginByEsiaView;

public abstract class LoginByEsiaPresenter extends BasePresenter<LoginByEsiaView> {
    public abstract void saveEsiaMarker(EsiaTokenMarker marker);

    public abstract void interruptRequest();

    public abstract void getPatient();
}
