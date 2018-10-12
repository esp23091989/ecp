package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by comp on 06.04.17.
 */

public class VisitHistoryResponse extends ErrorResponse {
    public long _id;
    @SerializedName("Items")
    @Expose
    private List<Visit> visitList = new ArrayList<Visit>();

    /**
     * @return The Data
     */
    public List<Visit> getVisitList() {
        return visitList;
    }

    /**
     * @param Data The Data
     */
    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}
