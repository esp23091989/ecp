package com.ibis.ibisecp2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by danila on 21.07.16.
 */
public class TextModel implements Parcelable {
    public static final Creator<TextModel> CREATOR = new Creator<TextModel>() {
        @Override
        public TextModel createFromParcel(Parcel in) {
            return new TextModel(in);
        }

        @Override
        public TextModel[] newArray(int size) {
            return new TextModel[size];
        }
    };
    private String t1;
    private String t2;

    public TextModel() {
    }

    protected TextModel(Parcel in) {
        t1 = in.readString();
        t2 = in.readString();
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(t1);
        dest.writeString(t2);
    }
}
