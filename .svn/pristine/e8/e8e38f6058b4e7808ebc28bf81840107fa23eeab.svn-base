package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by danila on 24.11.15.
 */
public class Visit {
    public long _id;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("CaseNumber")
    @Expose
    private String caseNumber;
    @SerializedName("ClinicName")
    @Expose
    private String clinicName;
    @SerializedName("DoctorName")
    @Expose
    private String doctorName;
    @SerializedName("ScheduleId")
    @Expose
    private String scheduleId;
    @SerializedName("Source")
    @Expose
    private String source;
    @SerializedName("SpecialityName")
    @Expose
    private String specialityName;
    @SerializedName("StartOn")
    @Expose
    private String startOn;
    @SerializedName("Status")
    @Expose
    private String status;
    private Long time;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    /**
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The clinicName
     */
    public String getClinicName() {
        return clinicName;
    }

    /**
     * @param clinicName The ClinicName
     */
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    /**
     * @return The doctorName
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * @param doctorName The DoctorName
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * @return The scheduleId
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId The ScheduleId
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * @return The specialityName
     */
    public String getSpecialityName() {
        return specialityName;
    }

    /**
     * @param specialityName The SpecialityName
     */
    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    /**
     * @return The startOn
     */
    public String getStartOn() {
        return startOn;
    }

    /**
     * @param startOn The StartOn
     */
    public void setStartOn(String startOn) {
        this.startOn = startOn;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }


    public Date getDate() {
        Date now = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            now = simpleDateFormat.parse(startOn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return now;
    }

    public static void sortEarlyVisits(List<Visit> visitList) {
        Collections.sort(visitList, new Comparator<Visit>() {
            @Override
            public int compare(Visit o1, Visit o2) {
                int result = nullSafeStringComparator(o1, o2);
                if (result != 0) {
                    return result;
                }

                return nullSafeStringComparator(o1, o2);
            }
        });

    }


    public static void sortLaterVisits(List<Visit> visitList) {
        Collections.sort(visitList, new Comparator<Visit>() {
            @Override
            public int compare(Visit o2, Visit o1) {
                int result = nullSafeStringComparator(o1, o2);
                if (result != 0) {
                    return result;
                }

                return nullSafeStringComparator(o1, o2);
            }
        });

    }

    private static int nullSafeStringComparator(final Visit one, final Visit two) {
        if (one.getDate() == null ^ two.getDate() == null) {
            return (one.getDate() == null) ? -1 : 1;
        }

        if (one.getDate() == null && two.getDate() == null) {
            return 0;
        }

        return one.getDate().compareTo(two.getDate());
    }

}
