package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.LoginView;

/**
 * Created by danila on 09.08.16.
 */
public abstract class LoginPresenter extends BasePresenter<LoginView> {
    public abstract void login(String login, String password, boolean isSavePass, String type);

    public abstract void openAgreement();

    public abstract void interruptRequest();
}
