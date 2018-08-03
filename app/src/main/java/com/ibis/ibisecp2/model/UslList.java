package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by comp on 09.03.17.
 */

public class UslList {
    @SerializedName("DateBgn")
    @Expose
    private String dateBgn;
    @SerializedName("DateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("UslCount")
    @Expose
    private String uslCount;
    @SerializedName("UslName")
    @Expose
    private String uslName;

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

    public String getUslCount() {
        return uslCount;
    }

    public void setUslCount(String uslCount) {
        this.uslCount = uslCount;
    }

    public String getUslName() {
        return uslName;
    }

    public void setUslName(String uslName) {
        this.uslName = uslName;
    }

}
