package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danila on 27.06.16.
 */
public class CurrentTime {
    @SerializedName("Item")
    @Expose
    private String currentTime;

    /**
     * @return The currentTime
     */
    public String getCurrentTime() {
        return currentTime;
    }

    /**
     * @param currentTime The CurrentTime
     */
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
