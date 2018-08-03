package com.ibis.ibisecp2.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;

/**
 * Created by danila on 15.09.16.
 */
public class ViewUtils {
    public static void setEditorListener(TextView editText) {
        TextView.OnEditorActionListener
                onEditorActionListener = (v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                AndroidUtils.hideKeyboard(v);
                return true;
            }
            return false;
        };
        editText.setOnEditorActionListener(onEditorActionListener);
    }

    public static void setDrawableCancelListener(final TextView editText) {
        View.OnTouchListener onTouchListener = (v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP &&
                    editText.getCompoundDrawables()[DRAWABLE_RIGHT] != null) {

                final Rect bounds = editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds();
                final int x = (int) event.getX();

                if (v.getWidth() - x <= bounds.width()) {
                    editText.setText("");
                    editText.clearFocus();
                    AndroidUtils.hideKeyboard(v);
                    return true;
                }
            }
            return false;
        };
        editText.setOnTouchListener(onTouchListener);
    }

    public static void clearIconSetup(final TextView editText) {
        if (editText.length() > 0) {
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    android.R.drawable.ic_menu_close_clear_cancel, 0);
        } else {
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public static void addTextView(Context context, LinearLayout linearLayout,
                                   java.lang.CharSequence text) {
        View view = LayoutInflater.from(context).inflate(R.layout.separator, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, AndroidUtils.dpToPx(1)));
        linearLayout.addView(view);
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        textView.setText(text);
        textView.setTextSize(16);
        linearLayout.addView(textView);
    }

    public static void setOnActionExpandListener(MenuItem searchItem, CardView cvDepartmentTitle) {
        MenuItemCompat.setOnActionExpandListener(searchItem,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionExpand(MenuItem menuItem) {
                        // Return true to allow the action view to expand
                        cvDepartmentTitle.setVisibility(View.GONE);
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                        // When the action view is collapsed, reset the query
                        cvDepartmentTitle.setVisibility(View.VISIBLE);
                        // Return true to allow the action view to collapse
                        return true;
                    }
                });
    }

}
