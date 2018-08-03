package com.ibis.ibisecp2.helpers;

import android.location.Location;

/**
 * Created by danila on 25.11.16.
 */

public interface LocationHelper {
    Location getLoc();

    void test();

    //    Observable<Location> getLocation();
    void stopUsingGPS();
}
