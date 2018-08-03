package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by danila on 14.12.16.
 */

public class Tasks {
    @SerializedName("Items")
    @Expose
    private List<Task> items = null;

    /**
     * @return The items
     */
    public List<Task> getItems() {
        return items;
    }

    /**
     * @param items The Items
     */
    public void setItems(List<Task> items) {
        this.items = items;
    }
}
