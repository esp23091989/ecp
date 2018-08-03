package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danila on 20.11.15.
 */
public class Speciality {
    @SerializedName("Name")
    @Expose
    private String nameSpeciality;
    @SerializedName("SpecialityId")
    @Expose
    private String specialityId;

    /**
     * @return The Name
     */
    public String getName() {
        return nameSpeciality;
    }

    /**
     * @param Name The Name
     */
    public void setName(String Name) {
        this.nameSpeciality = Name;
    }

    /**
     * @return The SpecialityId
     */
    public String getSpecialityId() {
        return specialityId;
    }

    /**
     * @param specialityId The SpecialityId
     */
    public void setSpecialityId(String specialityId) {
        this.specialityId = specialityId;
    }
}
