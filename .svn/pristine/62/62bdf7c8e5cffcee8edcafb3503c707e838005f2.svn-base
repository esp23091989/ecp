package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danila on 22.11.15.
 */
public class RelativeResponse extends ErrorResponse {
    @SerializedName("Data")
    @Expose
    private List<Patient> relativeList = new ArrayList<Patient>();

    /**
     * @return The Data
     */
    public List<Patient> getRelativeList() {
        return relativeList;
    }

    /**
     * @param Data The Data
     */
    public void setRelativeList(List<Patient> relativeList) {
        this.relativeList = relativeList;
    }

}
