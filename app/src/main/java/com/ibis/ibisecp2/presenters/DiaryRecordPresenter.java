package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment;
import com.ibis.ibisecp2.ui.view.DiaryRecordView;

/**
 * Created by danila on 08.08.16.
 */
public abstract class DiaryRecordPresenter extends BasePresenter<DiaryRecordView> {
    public abstract void getDiaryRecords(String period);

    public abstract void openTasksScreen(DiaryRecordsFragment recordsFragment);
}
