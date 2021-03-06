package com.ibis.ibisecp2.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by danila on 10.11.15.
 */
public class AndroidUtils {
    public static void showKeyboard(final View view) {
        if (view == null) {
            return;
        }

        view.postDelayed(() -> {
            InputMethodManager inputManager = (InputMethodManager) view.getContext()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.showSoftInput(view, 0);
        }, 500);
    }


    public static void hideKeyboard(View view) {
        if (view == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (!imm.isActive()) {
            return;
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideKeyboard(Fragment fragment){
        if(fragment.getActivity() == null)
            return;

        InputMethodManager imm = (InputMethodManager) fragment.getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (!imm.isActive()) {
            return;
        }
        imm.hideSoftInputFromWindow(fragment.getView().getWindowToken(), 0);
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
