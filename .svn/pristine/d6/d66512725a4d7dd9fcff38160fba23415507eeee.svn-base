package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitHistoryResponse;
import com.ibis.ibisecp2.model.VisitResponse;
import com.ibis.ibisecp2.presenters.RegistryPagerPresenter;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by comp on 06.04.17.
 */

public class RegistryPagerPresenterImpl extends RegistryPagerPresenter {

    private Storage mStorage;
    private RxUtil mRxUtil;

    @Inject
    public RegistryPagerPresenterImpl(Storage storage, RxUtil rxUtil) {
        mStorage = storage;
        mRxUtil = rxUtil;
    }

    @Override
    public void loadVisits(boolean isHistory) {
        unsubscribedSubscription();
        if (isHistory) {
            subscription = mStorage.getArrayListFromDb(VisitHistoryResponse.class)
                    .compose(mRxUtil.applySchedulers())
                    .subscribe(new Observer<List<VisitHistoryResponse>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<VisitHistoryResponse> visitHistoryResponseList) {
                            if (visitHistoryResponseList != null) {
                                List<Visit> visitList = visitHistoryResponseList.get(0).getVisitList();
                                Visit.sortLaterVisits(visitList);
                                view.showVisits(visitList);
                            }
                        }
                    });
        } else {
            subscription = mStorage.getArrayListFromDb(VisitResponse.class)
                    .compose(mRxUtil.applySchedulers())
                    .subscribe(new Observer<List<VisitResponse>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<VisitResponse> visitHistoryResponseList) {
                            if (visitHistoryResponseList != null) {
                                List<Visit> visitList = visitHistoryResponseList.get(0).getVisitList();
                                Visit.sortEarlyVisits(visitList);
                                view.showVisits(visitList);
                            }
                        }
                    });
        }
    }
}
