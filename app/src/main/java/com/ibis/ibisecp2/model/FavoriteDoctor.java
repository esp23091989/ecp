package com.ibis.ibisecp2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by comp on 21.04.17.
 */

public class FavoriteDoctor extends Doctor implements Parcelable {

    public static final Creator<FavoriteDoctor> CREATOR = new Creator<FavoriteDoctor>() {
        @Override
        public FavoriteDoctor createFromParcel(Parcel in) {
            return new FavoriteDoctor(in);
        }

        @Override
        public FavoriteDoctor[] newArray(int size) {
            return new FavoriteDoctor[size];
        }
    };
    private String clinic;
    private String clinicId;

    public FavoriteDoctor() {
    }

    //    clinicId, depCode, doctorId, profCode, positionCode, beginDate
    public FavoriteDoctor(String clinic, String clinicId,
                          String depCode, String doctorId, String profCode,
                          String positionCode, String beginDate, String speciality,
                          String docName, String deptName, String deptAddress) {
        this.clinic = clinic;
        this.clinicId = clinicId;
        this.deptCode = depCode;
        this.snils = doctorId;
        this.profCode = profCode;
        this.positionCode = positionCode;
        this.nearestDate = beginDate;
        this.positionName = speciality;
        this.specialityName = docName;
        this.deptName = deptName;
        this.deptAddress = deptAddress;
    }

    protected FavoriteDoctor(Parcel in) {
        clinic = in.readString();
        clinicId = in.readString();
        this.deptCode = in.readString();
        this.snils = in.readString();
        this.profCode = in.readString();
        this.positionCode = in.readString();
        this.nearestDate = in.readString();
        this.positionName = in.readString();
        this.specialityName = in.readString();
        this.deptName = in.readString();
        this.deptAddress = in.readString();
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(clinic);
        dest.writeString(clinicId);
        dest.writeString(deptCode);
        dest.writeString(snils);
        dest.writeString(profCode);
        dest.writeString(positionCode);
        dest.writeString(nearestDate);
        dest.writeString(positionName);
        dest.writeString(specialityName);
        dest.writeString(deptName);
        dest.writeString(deptAddress);
    }
}
