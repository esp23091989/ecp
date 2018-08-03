package com.ibis.ibisecp2.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

import com.ibis.ibisecp2.R;

/**
 * Created by danila on 30.12.15.
 */
public class TextUtils {
    public static Spannable spanBoldText(String txt, String nameClinic, Context context) {
        Spannable text = new SpannableString(txt + "  " + nameClinic);
        text.setSpan(new StyleSpan(Typeface.BOLD), 0, txt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context,
                R.color.textSecondaryPrimary)),
                txt.length(), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return text;
    }

    public static Spannable spanClinicText(String nameClinic) {
        Spannable text = new SpannableString(nameClinic);
        text.setSpan(new StyleSpan(Typeface.BOLD), nameClinic.indexOf("\""),
                nameClinic.lastIndexOf("\""), 0);
        return text;
    }

    public static Spannable spanGreyText(String titleDep, String address, Context context) {
        if (titleDep == null) titleDep = "";
        Spannable text = new SpannableString(titleDep);
        if (address != null) {
            text = new SpannableString(titleDep + "\n" + address);
            text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context,
                    R.color.textSecondaryPrimary)), titleDep.length(), text.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return text;
    }

    public static Spannable greyText(String titleDep, String address, Context context) {
        Spannable text = new SpannableString(titleDep);
        if (address != null) {
            text = new SpannableString(titleDep + " " + address);
            text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context,
                    R.color.textSecondaryPrimary)), titleDep.length(), text.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return text;
    }
}
