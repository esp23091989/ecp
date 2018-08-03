package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.DiaryEditRecordsView;

/**
 * Created by danila on 09.08.16.
 */
public abstract class DiaryEditRecordsPresenter extends BasePresenter<DiaryEditRecordsView> {
    public abstract void saveDiary(String note, String date);
}
