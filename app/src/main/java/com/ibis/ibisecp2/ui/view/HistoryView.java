package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.Visit;

import java.util.List;

/**
 * Created by danila on 20.02.17.
 */

public interface HistoryView {
    void showHistory(List<Visit> visitList);

    void errorLoad();

    void showLoad();

    void cancelVisit();
}
