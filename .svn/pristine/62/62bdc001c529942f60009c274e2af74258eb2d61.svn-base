package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by danila on 23.12.15.
 */
public class Recipe {
    @SerializedName("recipeSeries")
    @Expose
    private String recipeSeries;
    @SerializedName("recipeNumber")
    @Expose
    private Integer recipeNumber;
    @SerializedName("recipeDate")
    @Expose
    private String recipeDate;
    @SerializedName("mnn")
    @Expose
    private String mnn;
    @SerializedName("trn")
    @Expose
    private String trn;
    @SerializedName("doctorFirstname")
    @Expose
    private String doctorFirstname;
    @SerializedName("doctorLastname")
    @Expose
    private String doctorLastname;
    @SerializedName("doctorPatronymic")
    @Expose
    private String doctorPatronymic;
    @SerializedName("dosageForm")
    @Expose
    private String dosageForm;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("dosage")
    @Expose
    private String dosage;

    public static List<Recipe> sortRecipeList(List<Recipe> recipeList) {
        Comparator<Recipe> recipeComparator = new Comparator<Recipe>() {
            public int compare(Recipe o1, Recipe o2) {
                int compareNameResult = o1.getRecipeDate().compareTo(o2.getRecipeDate());
                if (compareNameResult == 0) {
                    return o1.getRecipeDate().compareTo(o2.getRecipeDate());
                }

                return compareNameResult;
            }
        };
        Collections.sort(recipeList, recipeComparator);
        return recipeList;
    }

    /**
     * @return The recipeSeries
     */
    public String getRecipeSeries() {
        return recipeSeries;
    }

    /**
     * @param recipeSeries The recipeSeries
     */
    public void setRecipeSeries(String recipeSeries) {
        this.recipeSeries = recipeSeries;
    }

    /**
     * @return The recipeNumber
     */
    public Integer getRecipeNumber() {
        return recipeNumber;
    }

    /**
     * @param recipeNumber The recipeNumber
     */
    public void setRecipeNumber(Integer recipeNumber) {
        this.recipeNumber = recipeNumber;
    }

    /**
     * @return The recipeDate
     */
    public String getRecipeDate() {
        return recipeDate;
    }

    /**
     * @param recipeDate The recipeDate
     */
    public void setRecipeDate(String recipeDate) {
        this.recipeDate = recipeDate;
    }

    /**
     * @return The mnn
     */
    public String getMnn() {
        return mnn;
    }

    /**
     * @param mnn The mnn
     */
    public void setMnn(String mnn) {
        this.mnn = mnn;
    }

    /**
     * @return The trn
     */
    public String getTrn() {
        return trn;
    }

    /**
     * @param trn The trn
     */
    public void setTrn(String trn) {
        this.trn = trn;
    }

    /**
     * @return The doctorFirstname
     */
    public String getDoctorFirstname() {
        return doctorFirstname;
    }

    /**
     * @param doctorFirstname The doctorFirstname
     */
    public void setDoctorFirstname(String doctorFirstname) {
        this.doctorFirstname = doctorFirstname;
    }

    /**
     * @return The doctorLastname
     */
    public String getDoctorLastname() {
        return doctorLastname;
    }

    /**
     * @param doctorLastname The doctorLastname
     */
    public void setDoctorLastname(String doctorLastname) {
        this.doctorLastname = doctorLastname;
    }

    /**
     * @return The doctorPatronymic
     */
    public String getDoctorPatronymic() {
        return doctorPatronymic;
    }

    /**
     * @param doctorPatronymic The doctorPatronymic
     */
    public void setDoctorPatronymic(String doctorPatronymic) {
        this.doctorPatronymic = doctorPatronymic;
    }

    /**
     * @return The dosageForm
     */
    public String getDosageForm() {
        return dosageForm;
    }

    /**
     * @param dosageForm The dosageForm
     */
    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    /**
     * @return The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return The dosage
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * @param dosage The dosage
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFioDoc() {
        return doctorLastname + " " + doctorFirstname + " " + doctorPatronymic;
    }
}
