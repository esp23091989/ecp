package com.ibis.ibisecp2.helpers.impl;

import android.app.Activity;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.ui.activity.BaseActivity;

import javax.inject.Inject;

/**
 * Created by comp on 12.04.17.
 */

public class ShowHideLoadHelperImpl implements ShowHideLoadHelper {

    private Activity activity;

    @Inject
    public ShowHideLoadHelperImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showLoad() {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).showLoad();
        }
    }

    @Override
    public void hideLoad() {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).hideLoad();
        }
    }
}
