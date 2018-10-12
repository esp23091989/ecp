package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.model.VisitResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by danila on 28.10.16.
 */

public interface VisitLoadHelper {
    Observable<VisitResponse> getVisits();

    Observable<Boolean> saveVisit(Visit visit);

    Observable<Boolean> saveVisitList(List<Visit> visitList);

    Observable<Boolean> deleteVisit(long id);

    Observable<Visit> getVisit(long id);

    Observable<List<Visit>> getVisitList();
}
