package com.ibis.ibisecp2.ui.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by danila on 16.11.16.
 */

public class DateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    TextView etDate;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public DateDialogFragment() {

    }

    @SuppressLint("ValidFragment")
    public DateDialogFragment(View view) {
        etDate = (TextView) view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        if (etDate.getText().length() != 0) {
            Date now;
            try {
                now = simpleDateFormat.parse(etDate.getText().toString());
                calendar.setTime(now);
            } catch (ParseException e) {
//            e.printStackTrace();
            }
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "." + (1 + monthOfYear) + "." + year;
        try {
            Date now = simpleDateFormat.parse(date);
            etDate.setText(simpleDateFormat.format(now));
        } catch (ParseException e) {
//            e.printStackTrace();
        }

    }
}
