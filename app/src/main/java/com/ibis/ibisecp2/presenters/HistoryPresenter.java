package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.HistoryView;

/**
 * Created by danila on 20.02.17.
 */

public abstract class HistoryPresenter extends BasePresenter<HistoryView> {
    public abstract void loadHistory(boolean isLoad);

    public abstract void cancelVisit(String scheduleId, long id);
}
