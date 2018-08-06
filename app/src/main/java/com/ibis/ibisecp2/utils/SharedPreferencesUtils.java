package com.ibis.ibisecp2.utils;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.ibis.ibisecp2.model.EsiaTokenMarker;

/**
 * Created by danila on 08.12.15.
 */
public class SharedPreferencesUtils {
    public static final String APP_PREFERENCES = "preferences";
    public static final String PATIENT_ID = "patientId";
    public static final String KEY_SNILS = "snils";
    public static final String KEY_PERIOD = "period";
    public static final String KEY_REMINDER = "reminder";
    public static final String KEY_NOTIFICATION = "notification";
    public static final String KEY_REMINDER_ITEM = "reminderItem";
    public static final String KEY_CLINIC_ID = "clinicId";
    public static final String KEY_CITY_ID = "cityId";
    public static final String KEY_ITEM_ID = "itemId";
    public static final String KEY_URL = "url";
    public static final String KEY_ESIA_MARKER = "esiaMarker";
    // All Shared Preferences Keys
    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_TIME = "time";

    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    public SharedPreferencesUtils(@NonNull SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public void savePatientId(long patientId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putLong(PATIENT_ID, patientId);
        // commit changes
        editor.commit();
    }

    public long getPatientId() {
        return sharedPreferences.getLong(PATIENT_ID, -1);
    }

    public void saveSnils(String snils) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putString(KEY_SNILS, snils);

        // commit changes
        editor.commit();
    }

    public String getSnils() {
        return sharedPreferences.getString(KEY_SNILS, null);
    }

    public void saveTime(String time) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putString(KEY_TIME, time);

        // commit changes
        editor.commit();
    }

    public String getTime() {
        return sharedPreferences.getString(KEY_TIME, null);
    }

    public void saveReminder(long time) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putLong(KEY_REMINDER, time);

        // commit changes
        editor.commit();
    }

    public long getReminder() {
        return sharedPreferences.getLong(KEY_REMINDER, 0);
    }

    public void saveReminderValue(String time) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putString(KEY_REMINDER_ITEM, time);

        // commit changes
        editor.commit();
    }

    public String getReminderValue() {
        return sharedPreferences.getString(KEY_REMINDER_ITEM, null);
    }

    public void saveClinicId(String clinicId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_CLINIC_ID, clinicId);
        editor.commit();
    }

    public String getClinicId() {
        return sharedPreferences.getString(KEY_CLINIC_ID, "");
    }

    public void deleteClinicId() {
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.remove(KEY_CLINIC_ID);
        sharedPreferencesEditor.commit();
    }

    public void saveCityId(String cityId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_CITY_ID, cityId);
        editor.commit();
    }

    public String getCityId() {
        return sharedPreferences.getString(KEY_CITY_ID, null);
    }

    public void deleteCityId() {
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.remove(KEY_CITY_ID);
        sharedPreferencesEditor.commit();
    }

    public void saveItemId(int id) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putInt(KEY_ITEM_ID, id);

        // commit changes
        editor.commit();
    }

    public int getItemId() {
        return sharedPreferences.getInt(KEY_ITEM_ID, -1);
    }

    public void onNotification(boolean isCheck) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putBoolean(KEY_NOTIFICATION, isCheck);

        // commit changes
        editor.commit();
    }

    public boolean getNotification() {
        return sharedPreferences.getBoolean(KEY_NOTIFICATION, false);
    }

    public void hasPassword(boolean isCheck) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_PASSWORD, isCheck);
        editor.commit();
    }

    public boolean getPassword() {
        return sharedPreferences.getBoolean(KEY_PASSWORD, false);
    }

    public String getUrl() {
        return sharedPreferences.getString(KEY_URL, "");
    }

    public void saveUrl(String url) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Storing name in pref
        editor.putString(KEY_URL, url);

        // commit changes
        editor.commit();
    }

    public EsiaTokenMarker getEsiaMarker() {
        return gson.fromJson(sharedPreferences.getString(KEY_ESIA_MARKER, ""), EsiaTokenMarker.class);
    }

    public void saveEsiaMarker(EsiaTokenMarker marker) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ESIA_MARKER, gson.toJson(marker));
        editor.commit();
    }
}
