package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.model.ItemResponse;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitHistoryResponse;
import com.ibis.ibisecp2.presenters.HistoryPresenter;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by danila on 20.02.17.
 */

public class HistoryPresenterImpl extends HistoryPresenter {
    private ChangeVisitHelper changeVisitHelper;
    private DialogsHelper dialogsHelper;
    private List<Visit> visitList = new ArrayList<Visit>();
    private Storage storage;
    private Navigator navigator;
    private VisitHistoryResponse mVisitResp;

    @Inject
    public HistoryPresenterImpl(ChangeVisitHelper changeVisitHelper, DialogsHelper dialogsHelper,
                                Storage storage, Navigator navigator) {
        this.changeVisitHelper = changeVisitHelper;
        this.dialogsHelper = dialogsHelper;
        this.storage = storage;
        this.navigator = navigator;
    }

    @Override
    public void loadHistory(boolean isLoad) {
        if (subscription != null) subscription.unsubscribe();
        subscription = changeVisitHelper.getHistory().cache()
                .flatMap((Func1<VisitHistoryResponse, Observable<Boolean>>) visitResponse -> {
                    mVisitResp = visitResponse;
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
                            view.errorLoad();
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (isViewAttached()) {
                            visitList.clear();
                            visitList = mVisitResp.getVisitList();
                            Visit.sortLaterVisits(visitList);
                            view.showHistory(visitList);
                        }
                    }
                });

    }

    @Override
    public void cancelVisit(String scheduleId, long id) {
        if (subscription != null) subscription.unsubscribe();
        view.showLoad();

        // 3 = cancel visit
        subscription = changeVisitHelper.changeVisit(scheduleId, 3)
                .flatMap(new Func1<ItemResponse, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(ItemResponse itemResponse) {
                        return changeVisitHelper.deleteVisit(id);
                    }
                })
                .flatMap((Func1<Boolean, Observable<EventCalendar>>) aBoolean ->
                        storage.getObjectById(EventCalendar.class, id))
                .subscribe(new Observer<EventCalendar>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        dialogsHelper.alertDialogError(e);
                        view.errorLoad();
                    }

                    @Override
                    public void onNext(EventCalendar response) {
                        if (response != null) {
                            navigator.deleteAlarm(Long.parseLong(response.getEventId()));
                            deleteReminder(id);
                        } else {
                            view.cancelVisit();
                        }
                    }
                });
    }

    private void deleteReminder(long id) {
        if (subscription != null) subscription.unsubscribe();
        subscription = changeVisitHelper.deleteReminder(id)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Boolean visitResponse) {
                        view.cancelVisit();
                    }
                });

    }

}
