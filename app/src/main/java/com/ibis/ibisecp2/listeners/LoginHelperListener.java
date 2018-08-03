package com.ibis.ibisecp2.listeners;

import com.ibis.ibisecp2.model.Patient;

/**
 * Created by danila on 09.08.16.
 */
public interface LoginHelperListener {

    void loginSuccess(Patient patient);

    void loginError(Throwable e);

    void loginErrorMsg(String msg);
}
