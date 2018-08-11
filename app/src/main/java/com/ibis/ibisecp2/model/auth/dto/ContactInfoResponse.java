package com.ibis.ibisecp2.model.auth.dto;

import com.google.gson.annotations.SerializedName;

public class ContactInfoResponse {

    @SerializedName("value")
    String value;

    public String getValue() {
        return value;
    }
}
