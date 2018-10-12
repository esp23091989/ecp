package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.model.ItemResponse;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitResponse;
import com.ibis.ibisecp2.presenters.RemembersPresenter;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by danila on 08.08.16.
 */
public class RemembersPresenterImpl extends RemembersPresenter {

    private ChangeVisitHelper changeVisitHelper;
    private SharedPreferencesUtils preferencesUtils;
    private DialogsHelper dialogsHelper;
    private Navigator navigator;
    private Storage storage;
    private VisitResponse visitResp;

    @Inject
    public RemembersPresenterImpl(ChangeVisitHelper changeVisitHelper, DialogsHelper dialogsHelper,
                                  SharedPreferencesUtils preferencesUtils, Navigator navigator,
                                  Storage storage) {
        this.changeVisitHelper = changeVisitHelper;
        this.preferencesUtils = preferencesUtils;
        this.dialogsHelper = dialogsHelper;
        this.navigator = navigator;
        this.storage = storage;
    }

    @Override
    public void getTickets() {
        if (subscription != null) subscription.unsubscribe();
        view.showLoad();
        subscription = changeVisitHelper.getVisits()
                .flatMap((Func1<VisitResponse, Observable<Boolean>>) visitResponse -> {
                    visitResp = visitResponse;
                    return storage.saveItemInDb(visitResponse);
                })
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.hideLoad();
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (isViewAttached()) {
                            Visit.sortEarlyVisits(visitResp.getVisitList());
                            view.showTickets(visitResp.getVisitList());
                        }
                    }
                });

    }

    /**
     * зачем хранить в бд напоминание?
     */

    @Override
    public void cancelVisit(String scheduleId, String id) {
        if (subscription != null) subscription.unsubscribe();
        view.showLoad();

        // 3 = cancel visit
        subscription = changeVisitHelper.changeVisit(scheduleId, 3)
//                .flatMap(new Func1<ItemResponse, Observable<Boolean>>() {
//                    @Override
//                    public Observable<Boolean> call(ItemResponse itemResponse) {
//                        return changeVisitHelper.deleteVisit(id);
//                    }
//                })
                .flatMap((Func1<ItemResponse, Observable<EventCalendar>>) aBoolean
                        -> storage.getEventCalendar(id))
                .subscribe(new Observer<EventCalendar>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.hideLoad();
                        }
                    }

                    @Override
                    public void onNext(EventCalendar response) {
                        if (isViewAttached()) {
                            if (response != null) {
                                navigator.deleteAlarm(Long.parseLong(response.getEventId()));
                                deleteEvent(response);
                            } else {
                                view.cancelVisit();
                            }
                        }
                    }
                });
    }

    @Override
    public void openReminderTime(long id) {
        navigator.openReminderTime(id);
    }


    private void deleteEvent(EventCalendar eventCalendar) {
        if (subscription != null) subscription.unsubscribe();
        subscription = storage.deleteObjectById(EventCalendar.class, eventCalendar.get_id())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Boolean visitResponse) {
                        if (isViewAttached()) {
                            view.cancelVisit();
                        }
                    }
                });

    }
}
