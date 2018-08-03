package com.ibis.ibisecp2.utils;


import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;

public class Utils {
    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static void SetBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }

    public static float GetDensity(DisplayMetrics metrics, float activity_horizontal_margin, int h, int vh, int width) {
        float result = metrics.density;

        if (result < 2)
            result = (float) 1.5;

        if (metrics.widthPixels == 2560 || metrics.heightPixels == 2560)
            result = 4.35f;
        else {
            if (metrics.widthPixels < result * (h * 2 + vh * 2 + width + 2 * activity_horizontal_margin)) {
                while (metrics.widthPixels < result * (h * 2 + vh * 2 + width + 2 * activity_horizontal_margin))
                    result = result * 0.99f;
            } else {
                while (metrics.widthPixels > result * (h * 2 + vh * 2 + width + 2 * activity_horizontal_margin))
                    result = result * 1.01f;
            }
        }

        return result;
    }

    public static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
