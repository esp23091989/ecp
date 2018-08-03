package com.ibis.ibisecp2.presenters;

import android.view.View;

import com.ibis.ibisecp2.ui.view.ReminderTimeView;

/**
 * Created by danila on 17.11.16.
 */

public abstract class ReminderTimePresenter extends BasePresenter<ReminderTimeView> {
    public abstract void setReminderTime(View v);

    public abstract void setReminderData(View v);

    public abstract void saveReminder(String data, long id);

    public abstract void deleteReminder();

    public abstract void getReminder(long id);
}
