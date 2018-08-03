package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.ConfirmSmsView;

/**
 * Created by comp on 21.03.17.
 */

public abstract class ConfirmSmsPresenter extends BasePresenter<ConfirmSmsView> {
    public abstract void confirm(String login, String code, boolean isSavePass);
}
