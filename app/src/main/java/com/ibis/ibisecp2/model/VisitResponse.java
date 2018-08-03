package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danila on 24.11.15.
 */
public class VisitResponse extends ErrorResponse {
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
