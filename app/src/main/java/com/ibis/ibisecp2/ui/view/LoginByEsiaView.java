package com.ibis.ibisecp2.ui.view;

/**
 * Created by Юленька on 03.08.2018.
 */

public interface LoginByEsiaView {

    void showWebLoading();

    void hideWebLoading();

    void errorLoginMsg(String e);

    void showLoading();

    void hideLoading();

    void savePatient();
}
