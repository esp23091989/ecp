package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danila on 26.11.15.
 */
public class ErrorResponse {

    @SerializedName("Error")
    @Expose
    protected Error Error;

    /**
     * @return The Error
     */
    public Error getError() {
        return Error;
    }

    /**
     * @param Error The Error
     */
    public void setError(Error Error) {
        this.Error = Error;
    }
}
