package com.ibis.ibisecp2.ui.view;

/**
 * Created by comp on 21.03.17.
 */

public interface ConfirmSmsView {
    void onSuccessConfirm();

    void onErrorConfirm();

    void onErrorConfirmOther();

    void onErrorTryConfirm();

    void onErrorChild(String text);

    void errorLoginMsg(String e);
}
