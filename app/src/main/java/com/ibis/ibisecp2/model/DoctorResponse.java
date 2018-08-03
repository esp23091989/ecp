package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danila on 25.11.15.
 */
public class DoctorResponse extends ErrorResponse {
    @SerializedName("Items")
    @Expose
    private List<Doctor> doctorList = new ArrayList<Doctor>();

    /**
     * @return The Data
     */
    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    /**
     * @param doctorList The Data
     */
    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

}
