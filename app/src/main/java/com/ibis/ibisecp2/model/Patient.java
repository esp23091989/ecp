package com.ibis.ibisecp2.model;


import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Patient {

    public long _id;
    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("Error")
    @Expose
    private Error error;
    @SerializedName("EMail")
    @Expose
    private String eMail;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("MiddleName")
    @Expose
    private String middleName;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("SNILS")
    @Expose
    private String sNILS;
    @SerializedName("Children")
    @Expose
    private List<Child> children = null;
    @SerializedName("Warnings")
    @Expose
    private List<Warning> warnings = null;

    private String cityId;
    private String clinicId;
    private String cityName;
    private String clinicName;
    private String clinicAddress;
    private String clinicPhone;
    private boolean hasPass;

    private String mAddress;
    private LatLng mLatLng;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getBirthDate() {
        return birthDate.substring(0, 10);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSNILS() {
        return sNILS;
    }

    public void setSNILS(String sNILS) {
        this.sNILS = sNILS;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getClinicPhone() {
        return clinicPhone;
    }

    public void setClinicPhone(String clinicPhone) {
        this.clinicPhone = clinicPhone;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public boolean isHasPass() {
        return hasPass;
    }

    public void setHasPass(boolean hasPass) {
        this.hasPass = hasPass;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public LatLng getLatLng() {
        return mLatLng;
    }

    public void setLatLng(LatLng latLng) {
        mLatLng = latLng;
    }

    public List<Warning> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Warning> warnings) {
        this.warnings = warnings;
    }
}