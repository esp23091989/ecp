package com.ibis.ibisecp2.ui.view;

/**
 * Created by danila on 09.08.16.
 */
public interface LoginView {
    void errorLogin(Throwable e);

    void errorLoginMsg(String e);

    void savePatient();

    void onConfirm();

    void onErrorChild(String text);
}
