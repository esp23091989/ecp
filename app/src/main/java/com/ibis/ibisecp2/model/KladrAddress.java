package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danila on 23.11.15.
 */
public class KladrAddress {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("zip")
    @Expose
    private Object zip;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("typeShort")
    @Expose
    private String typeShort;
    @SerializedName("okato")
    @Expose
    private String okato;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("fullName")
    @Expose
    private String fullName;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The zip
     */
    public Object getZip() {
        return zip;
    }

    /**
     * @param zip The zip
     */
    public void setZip(Object zip) {
        this.zip = zip;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The typeShort
     */
    public String getTypeShort() {
        return typeShort;
    }

    /**
     * @param typeShort The typeShort
     */
    public void setTypeShort(String typeShort) {
        this.typeShort = typeShort;
    }

    /**
     * @return The okato
     */
    public String getOkato() {
        return okato;
    }

    /**
     * @param okato The okato
     */
    public void setOkato(String okato) {
        this.okato = okato;
    }

    /**
     * @return The contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType The contentType
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName The fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}