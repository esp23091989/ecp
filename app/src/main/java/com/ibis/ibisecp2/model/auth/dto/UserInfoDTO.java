package com.ibis.ibisecp2.model.auth.dto;

import com.google.gson.annotations.SerializedName;

public class UserInfoDTO {

    @SerializedName("firstName")
    private String firstName = "";

    @SerializedName("middleName")
    private String middleName = "";

    @SerializedName("lastName")
    private String lastName = "";

    @SerializedName("birthDate")
    private String birthDate = "";

    @SerializedName("birthPlace")
    private String birthPlace = "";

    @SerializedName("gender")
    private String gender = "";

    @SerializedName("snils")
    private String snils = "";

    @SerializedName("contacts")
    ContactsResponseDTO contacts;

    @SerializedName("kids")
    KidsResponseDTO kids;
}
