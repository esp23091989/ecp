package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by danila on 29.06.16.
 */
public class Sluch {
    @SerializedName("DateBgn")
    @Expose
    private String dateBgn;
    @SerializedName("DateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("LpuName")
    @Expose
    private String lpuName;
    @SerializedName("LpuType")
    @Expose
    private String lpuType;
    @SerializedName("SluchSum")
    @Expose
    private String sluchSum;
    @SerializedName("UslList")
    @Expose
    private List<UslList> uslList;

    public String getDateBgn() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", new Locale("ru", "RU"));
        Date date = null;
        try {
            date = fmt.parse(dateBgn);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
            dateBgn = fmtOut.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateBgn;
    }

    public void setDateBgn(String dateBgn) {
        this.dateBgn = dateBgn;
    }

    public String getDateEnd() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", new Locale("ru", "RU"));
        Date date = null;
        try {
            date = fmt.parse(dateEnd);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
            dateEnd = fmtOut.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLpuName() {
        return lpuName;
    }

    public void setLpuName(String lpuName) {
        this.lpuName = lpuName;
    }

    public String getLpuType() {
        return lpuType;
    }

    public void setLpuType(String lpuType) {
        this.lpuType = lpuType;
    }

    public String getSluchSum() {
        return sluchSum;
    }

    public void setSluchSum(String sluchSum) {
        this.sluchSum = sluchSum;
    }

    public List<UslList> getUslList() {
        return uslList;
    }

    public void setUslList(List<UslList> uslList) {
        this.uslList = uslList;
    }
}
