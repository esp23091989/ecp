package com.ibis.ibisecp2.model.auth.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ContactsListResponse {

    @SerializedName("elements")
    List<String> contactsRefList = new ArrayList<>();

    public ContactsListResponse(List<String> contactsRefList) {
        this.contactsRefList = contactsRefList;
    }

    public List<String> getContactsRefList() {
        return contactsRefList;
    }
}
