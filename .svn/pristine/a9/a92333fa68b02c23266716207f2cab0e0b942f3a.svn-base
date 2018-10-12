package com.ibis.ibisecp2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danila on 24.11.15.
 */
public class DiaryRecord implements Parcelable {

    public static final Creator<DiaryRecord> CREATOR = new Creator<DiaryRecord>() {
        @Override
        public DiaryRecord createFromParcel(Parcel in) {
            return new DiaryRecord(in);
        }

        @Override
        public DiaryRecord[] newArray(int size) {
            return new DiaryRecord[size];
        }
    };
    @SerializedName("note_date")
    @Expose
    private String Date;
    @SerializedName("note")
    @Expose
    private String Note;

    protected DiaryRecord(Parcel in) {
        Date = in.readString();
        Note = in.readString();
    }

    /**
     * @return The Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date The Date
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return The Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note The Note
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Date);
        parcel.writeString(Note);
    }
}
