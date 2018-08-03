package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.model.ItemResponse;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitHistoryResponse;
import com.ibis.ibisecp2.model.VisitResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by danila on 31.10.16.
 */

public interface ChangeVisitHelper {
    Observable<ItemResponse> changeVisit(String scheduleid, int code);

    Observable<VisitResponse> getVisits();

    Observable<VisitHistoryResponse> getHistory();

    Observable<Boolean> saveReminder(EventCalendar eventCalendar);

    Observable<Boolean> saveVisitList(List<Visit> visitList);

    Observable<Boolean> deleteVisit(long id);

    Observable<Boolean> deleteReminder(long id);

    Observable<List<Visit>> getVisitList();
}
