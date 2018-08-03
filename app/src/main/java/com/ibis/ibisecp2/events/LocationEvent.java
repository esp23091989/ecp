package com.ibis.ibisecp2.events;

import android.location.Location;

/**
 * Created by danila on 30.11.16.
 */

public class LocationEvent {
    private Location location;

    public LocationEvent() {
    }

    public LocationEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
