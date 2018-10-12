package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by danila on 25.11.15.
 */
public class Doctor {
    public long _id;
    @SerializedName("snils")
    @Expose
    protected String snils;
    @SerializedName("deptAddress")
    @Expose
    protected String deptAddress;
    @SerializedName("deptCode")
    @Expose
    protected String deptCode;
    @SerializedName("deptName")
    @Expose
    protected String deptName;
    @SerializedName("nearestDate")
    @Expose
    protected String nearestDate;
    @SerializedName("positionCode")
    @Expose
    protected String positionCode;
    @SerializedName("positionName")
    @Expose
    protected String positionName;
    @SerializedName("profCode")
    @Expose
    protected String profCode;
    @SerializedName("specialityName")
    @Expose
    protected String specialityName;

    public static List<Doctor> sortByFio(List<Doctor> doctorList) {
        Comparator<Doctor> doctorsComparator = (o1, o2) -> {
            int compareNameResult = o1.getSpecialityName().compareTo(o2.getSpecialityName());
            if (compareNameResult == 0) {
                return o1.getPositionName().compareTo(o2.getPositionName());
            }

            return compareNameResult;
        };
        Collections.sort(doctorList, doctorsComparator);
        return doctorList;
    }

    public static List<Doctor> sortBySpec(List<Doctor> doctorList) {
        Comparator<Doctor> doctorsComparator = new Comparator<Doctor>() {
            public int compare(Doctor o1, Doctor o2) {
                int compareNameResult = o1.getPositionName().compareTo(o2.getPositionName());
                if (compareNameResult == 0) {
                    return o1.getSpecialityName().compareTo(o2.getSpecialityName());
                }

                return compareNameResult;
            }
        };
        Collections.sort(doctorList, doctorsComparator);
        return doctorList;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getNearestDateFavoritDoctor()
    {
        Date date = new Date();
        SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
        fmtOut.setTimeZone(TimeZone.getTimeZone("Asia/Yekaterinburg"));
        nearestDate = fmtOut.format(date);
        return nearestDate;
    }

    public String getNearestDate() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", new Locale("ru", "RU"));
        Date date = null;
        try {
            date = fmt.parse(nearestDate);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
            nearestDate = fmtOut.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nearestDate;
    }

    public void setNearestDate(String nearestDate) {
      this.nearestDate = nearestDate;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getProfCode() {
        return profCode;
    }

    public void setProfCode(String profCode) {
        this.profCode = profCode;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

}
