package com.ibis.ibisecp2.helpers.impl;


import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.DialogAdapter;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.model.ErrorResponse;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.StartActivity;
import com.ibis.ibisecp2.utils.AndroidUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.HttpException;

/**
 * Created by danila on 26.06.16.
 */
public class DialogHelperImpl implements DialogsHelper {

    private Activity activity;
    private Navigator  mNavigator;

    @Inject
    public DialogHelperImpl(Activity activity,
                            Navigator navigator) {
        this.activity = activity;
        this.mNavigator = navigator;
    }

    public void createDialogCall() {
        List<String> selectList = new ArrayList<String>();
        selectList.add("Связь с оператором call-центра");
        selectList.add("Вызов скорой помощи");
//        final CharSequence[] select = selectList.toArray(new String[selectList.size()]);
        AlertDialog.Builder dialogBuilder =
                new AlertDialog.Builder(activity, R.style.MyAlertDialogStyle);
        DialogAdapter adapter =
                new DialogAdapter(activity, R.layout.dialog_item, selectList);
        dialogBuilder.setAdapter(adapter, (dialog, item) -> {
            if (item == 0) {
                mNavigator.startCallIntent("88001008603");
            } else if (item == 1) {
                mNavigator.startCallIntent("103");
            }
        });
        dialogBuilder.setNegativeButton("Отмена", (dialog, which) -> {
            dialog.dismiss();
        });
        dialogBuilder.setCancelable(true);
        AlertDialog alertDialog = dialogBuilder.create();
        setupDialogParams(alertDialog);
    }

    public void alertDialogError(Throwable e) {
        String msg = null;
        if (e instanceof IOException) {
            if (AndroidUtils.isNetworkConnected(activity)) {
                msg = activity.getResources().getText(R.string.error_message_service).toString();
            } else {
                msg = activity.getResources().getText(R.string.error_message_network).toString();
            }
        } else {
            Gson gson = new Gson();
            ErrorResponse error = null;
            try {
                error = gson.fromJson(((HttpException) e).response().errorBody().string(),
                        ErrorResponse.class);
                msg = error.getError().getErrorText();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        if (e instanceof HttpException && msg == null) {
            switch (((HttpException) e).code()) {
                case 404:
                    msg = activity.getString(R.string.error_message_404);
                    break;
                case 409:
                    msg = activity.getString(R.string.error_message_409);
                    break;
                case 500:
                    msg = activity.getString(R.string.error_message_500);
                    break;
                case 502:
                    msg = activity.getString(R.string.error_message_502);
                    break;
                case 503:
                    msg = activity.getString(R.string.error_message_503);
                    break;
                case 504:
                     msg = activity.getString(R.string.error_message_504);
                    break;
                default:
                    break;
            }
        }

        if (msg == null) {
            msg = e.getMessage();
        }
        showDialog(msg);
    }

    @Override
    public void alertDialogErrorMsg(String msg) {
        showDialog(msg);
    }

    @Override
    public void setupDialogParams(AlertDialog alertDialog) {
        alertDialog.show();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        if (alertDialog.getWindow() != null) {
            lp.copyFrom(alertDialog.getWindow().getAttributes());
        }
        lp.width = AndroidUtils.dpToPx(300);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        alertDialog.show();
        alertDialog.getWindow().setAttributes(lp);
    }

    private void showDialog(CharSequence msg) {
        AlertDialog.Builder dialogBuilder =
                new AlertDialog.Builder(activity, R.style.MyAlertDialogStyle);
        dialogBuilder.setMessage(msg);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(android.R.string.ok,
                (dialog, which) -> {
                    dialog.cancel();
                });
        AlertDialog alertDialog = dialogBuilder.create();
        setupDialogParams(alertDialog);
        if (msg.toString().contains("88001008603")) {
            showDialogWithClickableMessage(alertDialog, msg.toString(), "88001008603");
        }
    }

    private void showDialogWithClickableMessage(AlertDialog alertDialog,
                                                String message, String messageClickable) {

        SpannableString messageSpannable = new SpannableString(message);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (!((StartActivity) activity).runtimePermissionsCall(messageClickable)) {
                        mNavigator.startCallIntent(messageClickable);
                    }
                } else {
                    mNavigator.startCallIntent(messageClickable);
                }
            }
        };

        messageSpannable.setSpan(clickableSpan, message.indexOf(messageClickable),
                message.indexOf(messageClickable) + messageClickable.length(),
                Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        if ((alertDialog.findViewById(android.R.id.message)) != null) {
            ((TextView) alertDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        alertDialog.setMessage(messageSpannable);
    }
}
