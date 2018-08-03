package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danila on 09.11.15.
 */
public class ClinicResponse extends ErrorResponse {
    public long _id = 0;
    @SerializedName("Items")
    @Expose
    private List<Clinic> Data = new ArrayList<Clinic>();


    /**
     * @return The Data
     */
    public List<Clinic> getData() {
        return Data;
    }

    /**
     * @param Data The Data
     */
    public void setData(List<Clinic> Data) {
        this.Data = Data;
    }
}
