package com.ibis.ibisecp2.helpers.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ibis.ibisecp2.events.LocationEvent;
import com.ibis.ibisecp2.events.LocationEventError;
import com.ibis.ibisecp2.helpers.LocationHelper;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by danila on 25.11.16.
 */

public class LocationHelperImpl implements LocationHelper, LocationListener {

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 0 meters
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 5; // 5 sec
    private final LocationManager locationManager;
    private boolean checkGPS = false;
    private Context mContext;
    private boolean checkNetwork = false;
    private Location loc;

    @Inject
    public LocationHelperImpl(Context mContext) {
        this.mContext = mContext;
        locationManager = (LocationManager) mContext
                .getSystemService(LOCATION_SERVICE);
    }


    public Location getLoc() {
        // getting GPS status
        checkGPS = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        // getting network status
        checkNetwork = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!checkGPS && !checkNetwork) {
            Toast.makeText(mContext, "No Service Provider Available", Toast.LENGTH_SHORT).show();
            EventBus.getDefault().postSticky(new LocationEventError());
            loc = null;
        } else {
            // First get location from Network Provider
            if (checkNetwork) {
//                Toast.makeText(mContext, "Network", Toast.LENGTH_SHORT).show();

                try {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        loc = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        }
        // if GPS Enabled get lat/long using GPS Services
        if (checkGPS) {
//            Toast.makeText(mContext, "GPS", Toast.LENGTH_SHORT).show();
            if (loc == null) {
                try {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("GPS Enabled", "GPS Enabled");
                    if (locationManager != null) {
                        loc = locationManager
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    }
                } catch (SecurityException e) {

                }
            }
        }
        LocationEvent locationEvent = new LocationEvent(loc);
        EventBus.getDefault().postSticky(locationEvent);
        return loc;
    }

    @Override
    public void test() {

    }

//    public void test() {
//        if (subscription != null) subscription.unsubscribe();
//        subscription = getLocation().compose(rxUtil.applySchedulers())
//                .subscribe(new Observer<Location>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(Location location) {
//                        location.getTime();
//                    }
//                });
//    }


    @Override
    public void onLocationChanged(Location location) {
        LocationEvent locationEvent = new LocationEvent(location);
        EventBus.getDefault().postSticky(locationEvent);
        locationManager.removeUpdates(this);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void stopUsingGPS() {
        if (locationManager != null) {
            locationManager.removeUpdates(LocationHelperImpl.this);
        }
    }
}
