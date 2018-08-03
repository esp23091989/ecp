package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by danila on 30.11.15.
 */
public class Schedule {
    @SerializedName("ScheduleDate")
    @Expose
    private String scheduleDate;
    @SerializedName("ScheduleInfo")
    @Expose
    private String scheduleInfo;
    @SerializedName("SlotList")
    @Expose
    private List<SlotList> slotList = null;

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleInfo() {
        return scheduleInfo;
    }

    public void setScheduleInfo(String scheduleInfo) {
        this.scheduleInfo = scheduleInfo;
    }

    public List<SlotList> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<SlotList> slotList) {
        this.slotList = slotList;
    }

    public Date getDate() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        try {
            date = fmt.parse(scheduleDate);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
