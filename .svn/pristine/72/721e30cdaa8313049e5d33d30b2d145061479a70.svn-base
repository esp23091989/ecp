package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.ItemResponse;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitHistoryResponse;
import com.ibis.ibisecp2.model.VisitResponse;
import com.ibis.ibisecp2.presenters.VisitPresenter;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by comp on 06.04.17.
 */

public class VisitPresenterImpl extends VisitPresenter {
    private Storage mStorage;
    private RxUtil mRxUtil;
    private ChangeVisitHelper mChangeVisitHelper;
    private Navigator navigator;
    private DialogsHelper dialogsHelper;
    private Visit currentVisit;
    private PatientHelper mPatientHelper;
    private SharedPreferencesUtils preferencesUtils;

    @Inject
    public VisitPresenterImpl(Storage storage, RxUtil rxUtil, ChangeVisitHelper changeVisitHelper,
                              Navigator navigator, DialogsHelper dialogsHelper,
                              PatientHelper patientHelper, SharedPreferencesUtils preferencesUtils) {
        mStorage = storage;
        mRxUtil = rxUtil;
        mChangeVisitHelper = changeVisitHelper;
        this.navigator = navigator;
        this.dialogsHelper = dialogsHelper;
        mPatientHelper = patientHelper;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void getVisit(String caseNumber, boolean isHistory) {
        unsubscribedSubscription();
        if (isHistory) {
            subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                    .flatMap(new Func1<Patient, Observable<List<VisitHistoryResponse>>>() {
                        @Override
                        public Observable<List<VisitHistoryResponse>> call(Patient patient) {
                            view.showPatient(patient);
                            return mStorage.getArrayListFromDb(VisitHistoryResponse.class);
                        }
                    })
                    .subscribe(new Observer<List<VisitHistoryResponse>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<VisitHistoryResponse> visitHistoryResponseList) {
                            for (Visit visit : visitHistoryResponseList.get(0).getVisitList()) {
                                if (visit.getCaseNumber().equals(caseNumber)) {
                                    view.showVisit(visit);
                                    currentVisit = visit;
                                    break;
                                }
                            }
                        }
                    });
        } else {
            subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                    .flatMap(new Func1<Patient, Observable<List<VisitResponse>>>() {
                        @Override
                        public Observable<List<VisitResponse>> call(Patient patient) {
                            view.showPatient(patient);
                            return mStorage.getArrayListFromDb(VisitResponse.class);
                        }
                    })
                    .compose(mRxUtil.applySchedulers())
                    .subscribe(new Observer<List<VisitResponse>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<VisitResponse> visitResponseList) {
                            for (Visit visit : visitResponseList.get(0).getVisitList()) {
                                if (visit.getCaseNumber().equals(caseNumber)) {
                                    view.showVisit(visit);
                                    currentVisit = visit;
                                    break;
                                }
                            }
                        }
                    });
        }
    }

    @Override
    public void cancelVisit() {
        if (subscription != null) subscription.unsubscribe();
        // 3 = cancel visit
        subscription = mChangeVisitHelper.changeVisit(currentVisit.getScheduleId(), 3)
                .flatMap((Func1<ItemResponse, Observable<EventCalendar>>) aBoolean
                        -> mStorage.getEventCalendar(currentVisit.getCaseNumber()))
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

    private void deleteEvent(EventCalendar eventCalendar) {
        if (subscription != null) subscription.unsubscribe();
        subscription = mStorage.deleteObjectById(EventCalendar.class, eventCalendar.get_id())
                .compose(mRxUtil.applySchedulers())
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
