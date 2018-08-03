package com.ibis.ibisecp2.listeners;

import com.ibis.ibisecp2.model.DiaryRecord;

import java.util.List;

/**
 * Created by danila on 24.11.15.
 */
public interface DiaryRecordsLoaderHelperListener {
    void onSuccessLoadRecords(List<DiaryRecord> diaryRecordList);

    void onErrorLoadRecords();
}
