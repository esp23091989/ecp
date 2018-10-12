package com.ibis.ibisecp2.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.ibis.ibisecp2.R;

import rx.Subscription;


/**
 * Created by danila on 08.11.15.
 */
public class ProgressDialogUtils {
    static ProgressDialog progressDialog;

    public static void showProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.loading));
        progressDialog.setCancelable(true);
        progressDialog.show();

    }

    public static void showProgressDialog(final Context context, final Subscription subscription) {
//        progressDialog = new ProgressDialog(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.loading));
        progressDialog.setOnCancelListener(dialog -> {
            if (subscription != null) {
                subscription.unsubscribe();
            }
        });
        progressDialog.show();

    }

    public static void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


}
