package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danila on 09.11.15.
 */
public class Clinic {
    @SerializedName("ClinicId")
    @Expose
    private Integer clinicId;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Phone")
    @Expose
    private String phone;

    @SerializedName("Latitude")
    @Expose
    private double mLatitude = 0.0;
    @SerializedName("Longitude")
    @Expose
    private double mLongitude = 0.0;

    private double mDistance = 0.0;
    @SerializedName("CityId")
    @Expose
    private String cityId;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The clinicId
     */
    public Integer getClinicId() {
        return clinicId;
    }

    /**
     * @param clinicId The ClinicId
     */
    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    /**
     * @return The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName The FullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public double getDistance() {
        return mDistance;
    }

    public void setDistance(double distance) {
        mDistance = distance;
    }
}