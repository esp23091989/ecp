package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danila on 24.11.15.
 */
public class MedicamentResponse extends ErrorResponse {
    @SerializedName("Items")
    @Expose
    private List<Medicament> medicamentList = new ArrayList<Medicament>();

    /**
     * @return The Data
     */
    public List<Medicament> getMedicamentList() {
        return medicamentList;
    }

    /**
     * @param Data The Data
     */
    public void setMedicamentList(List<Medicament> medicamentList) {
        this.medicamentList = medicamentList;
    }
}
