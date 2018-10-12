package com.ibis.ibisecp2.presenters.impl;

import android.view.View;

import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.presenters.ReminderTimePresenter;
import com.ibis.ibisecp2.ui.Navigator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by danila on 17.11.16.
 */

public class ReminderTimePresenterImpl extends ReminderTimePresenter {

    private Navigator navigator;
    private VisitLoadHelper visitLoadHelper;
    private Visit currentVisit;

    @Inject
    public ReminderTimePresenterImpl(Navigator navigator, VisitLoadHelper visitLoadHelper) {
        this.navigator = navigator;
        this.visitLoadHelper = visitLoadHelper;
    }

    @Override
    public void setReminderTime(View v) {
        navigator.showTimeFragment(v);
    }

    @Override
    public void setReminderData(View v) {
        navigator.showDateFragment(v);
    }

    @Override
    public void saveReminder(String data, long id) {
        if (subscription != null) subscription.unsubscribe();
        view.showLoad();
        subscription = visitLoadHelper.getVisit(id).subscribe(new Observer<Visit>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError();
            }

            @Override
            public void onNext(Visit reminder) {
                view.hideLoad();
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    Date now = simpleDateFormat.parse(data);
                    reminder.setTime(now.getTime());
                    saveReminder(reminder);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void saveReminder(Visit visit) {
        if (subscription != null) subscription.unsubscribe();
        view.showLoad();
        currentVisit = visit;
        subscription = visitLoadHelper.saveVisit(visit).subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    view.showError();
                }
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (isViewAttached()) {
                    if (visit.getTime() != null && visit.getTime() != 0) {
                        navigator.createAlarm(visit.get_id());
                        view.success();
                    } else {
                        view.successDelete();
                    }
                }
            }
        });
    }

    @Override
    public void deleteReminder() {
        currentVisit.setTime(0L);
        saveReminder(currentVisit);
    }

    @Override
    public void getReminder(long id) {
        if (subscription != null) subscription.unsubscribe();
        view.showLoad();
        subscription = visitLoadHelper.getVisit(id).subscribe(new Observer<Visit>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    view.hideLoad();
                }
            }

            @Override
            public void onNext(Visit reminder) {
                if (isViewAttached()) {
                    view.hideLoad();
                    currentVisit = reminder;
                    if (reminder.getTime() != null && reminder.getTime() != 0) {
                        SimpleDateFormat data = new SimpleDateFormat("dd.MM.yyyy");
                        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(reminder.getTime());
                        String dataReminder = data.format(calendar.getTime());
                        String timeReminder = time.format(calendar.getTime());
                        view.setDataAndTime(dataReminder, timeReminder);
                    }
                }
            }
        });
    }
}
