package com.ibis.ibisecp2.ui.fragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by danila on 16.11.16.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    TextView etTime;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    public TimePickerFragment() {
        // Required empty public constructor
    }

    public static TimePickerFragment newInstance(View etTime) {
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.etTime = (TextView) etTime;
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // Use the current time as the default values for the picker

        final Calendar calendar = Calendar.getInstance();
        if (etTime.getText().length() != 0) {
            Date now;
            try {
                now = simpleDateFormat.parse(etTime.getText().toString());
                calendar.setTime(now);
            } catch (ParseException e) {
//            e.printStackTrace();
            }
        }

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;
        try {
            Date now = simpleDateFormat.parse(time);
            etTime.setText(simpleDateFormat.format(now));
        } catch (ParseException e) {
//            e.printStackTrace();
        }
    }
}
