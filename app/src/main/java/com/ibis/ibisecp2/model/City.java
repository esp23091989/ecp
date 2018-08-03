package com.ibis.ibisecp2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by danila on 20.11.15.
 */
public class City implements Parcelable {
    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
    @SerializedName("CityId")
    @Expose
    private String cityId;
    @SerializedName("Name")
    @Expose
    private String name;

    public City() {
    }


    protected City(Parcel in) {
        cityId = in.readString();
        name = in.readString();
    }

    public static ArrayList<Map.Entry<Character, List<City>>> GetCitiesByLetter(List<City> cityList) {
        ArrayList<Map.Entry<Character, List<City>>> map = new ArrayList<Map.Entry<Character, List<City>>>();

        // creating list for each char
        for (int i = 0; i < 32; i++) {
            char ch = (char) ('А' + i);
            if (ch != 'Ё' && ch != 'Ь' && ch != 'Ы' && ch != 'Ъ') {
                ArrayList<City> citiesByLetter = new ArrayList<City>();

                for (City city : cityList) {
                    if (ch == city.getName().charAt(0)) {
                        citiesByLetter.add(city);
                    }
                }

                for (City city : citiesByLetter) {
                    cityList.remove(city);
                }

                AbstractMap.SimpleEntry<Character, List<City>> entry =
                        new AbstractMap.SimpleEntry<Character, List<City>>(ch, citiesByLetter);

                map.add(entry);
            }
        }

        return map;
    }

    /**
     * @return The CityId
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * @param cityId The CityId
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * @return The Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The Name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cityId);
        dest.writeString(name);
    }
}
