package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.notification.Reminder;

import java.util.List;

import rx.Observable;

/**
 * Created by danila on 15.11.16.
 */

public interface ReminderHelper {
    Observable<Boolean> saveReminder(Reminder reminder);

    Observable<Boolean> deleteReminder(long id);

    Observable<Reminder> getReminder(long id);

    Observable<List<Reminder>> getReminderList();
}
