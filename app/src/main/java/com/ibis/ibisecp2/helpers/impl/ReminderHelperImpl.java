package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.ReminderHelper;
import com.ibis.ibisecp2.notification.Reminder;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 15.11.16.
 */

public class ReminderHelperImpl implements ReminderHelper {

    private Storage cupboard;
    private RxUtil rxUtil;

    @Inject
    public ReminderHelperImpl(Storage cupboard, RxUtil rxUtil) {
        this.cupboard = cupboard;
        this.rxUtil = rxUtil;
    }

    @Override
    public Observable<Boolean> saveReminder(Reminder reminder) {
        return cupboard.saveItemInDb(reminder).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> deleteReminder(long id) {
        return cupboard.deleteObjectById(Reminder.class, id)
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Reminder> getReminder(long id) {
        return cupboard.getObjectById(Reminder.class, id)
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<List<Reminder>> getReminderList() {
        return cupboard.getArrayListFromDb(Reminder.class)
                .compose(rxUtil.applySchedulers());
    }
}
