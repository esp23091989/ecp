package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by comp on 22.03.17.
 */

public class Child {
    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("Error")
    @Expose
    private Error error;
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
    @SerializedName("SNILS")
    @Expose
    private String sNILS;

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public String getBirthDate() {
        return birthDate.substring(0, 10);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
}
