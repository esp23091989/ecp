package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.model.ItemResponse;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitHistoryResponse;
import com.ibis.ibisecp2.model.VisitResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 31.10.16.
 */

public class ChangeVisitHelperImpl implements ChangeVisitHelper {

    private RxUtil rxUtil;
    private EcpAp ecpAp;
    private EncryptUtils encryptUtils;
    private Storage cupboard;

    @Inject
    public ChangeVisitHelperImpl(RxUtil rxUtil, EcpAp ecpAp, EncryptUtils encryptUtils,
                                 Storage cupboard) {
        this.rxUtil = rxUtil;
        this.ecpAp = ecpAp;
        this.encryptUtils = encryptUtils;
        this.cupboard = cupboard;
    }

    @Override
    public Observable<ItemResponse> changeVisit(String scheduleid, int code) {
        return ecpAp.changeVisit(scheduleid, code, encryptUtils.getToken())
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<VisitResponse> getVisits() {
        return ecpAp.getVisits(encryptUtils.getToken()).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<VisitHistoryResponse> getHistory() {
        return ecpAp.getHistory(encryptUtils.getToken()).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> saveReminder(EventCalendar visit) {
        return cupboard.saveItemInDb(visit).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> saveVisitList(List<Visit> visitList) {
        return cupboard.saveVisitListInDb(visitList).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> deleteVisit(long id) {
        return cupboard.deleteObjectById(Visit.class, id).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> deleteReminder(long id) {
        return cupboard.deleteObjectById(EventCalendar.class, id).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<List<Visit>> getVisitList() {
        return cupboard.getArrayListFromDb(Visit.class).compose(rxUtil.applySchedulers());
    }
}
