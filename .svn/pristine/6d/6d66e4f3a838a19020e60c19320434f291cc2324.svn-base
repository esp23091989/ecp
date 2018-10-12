package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danila on 24.11.15.
 */
public class DiaryRecordsResponse extends ErrorResponse {
    @SerializedName("Items")
    @Expose
    private List<DiaryRecord> diaryRecordList = new ArrayList<DiaryRecord>();


    /**
     * @return The Data
     */
    public List<DiaryRecord> getDiaryRecordList() {
        return diaryRecordList;
    }

    /**
     * @param Data
     */
    public void setDiaryRecordList(List<DiaryRecord> diaryRecordList) {
        this.diaryRecordList = diaryRecordList;
    }
}
