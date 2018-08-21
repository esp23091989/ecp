package com.ibis.ibisecp2.helpers.impl;

import android.app.Activity;
import android.app.ProgressDialog;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;

import javax.inject.Inject;

/**
 * Created by danila on 03.08.16.
 */
public class ProgressDialogHelperImpl implements ProgressDialogHelper {

    private Activity activity;
    private ProgressDialog progressDialog;

    @Inject
    public ProgressDialogHelperImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage(activity.getString(R.string.loading));
        }
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    @Override
    public void showNotCancelableDialog(){
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage(activity.getString(R.string.loading));
        }
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
