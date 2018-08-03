package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by danila on 20.11.15.
 */
public class CityResponse extends ErrorResponse {
    @SerializedName("Items")
    @Expose
    private ArrayList<City> cityList = new ArrayList<City>();

    /**
     * @return The Data
     */
    public ArrayList<City> getCityList() {
        return cityList;
    }

    /**
     * @param cityList The Data
     */
    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }
}
