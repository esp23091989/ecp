package com.ibis.ibisecp2.model.auth.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class KidsListResponse {

    @SerializedName("elements")
        List<String> kidsRefList = new ArrayList<>();

    public KidsListResponse(List<String> kidsRefList) {
        this.kidsRefList = kidsRefList;
    }

    public List<String> getKidsRefList() {
        return kidsRefList;
    }

}
