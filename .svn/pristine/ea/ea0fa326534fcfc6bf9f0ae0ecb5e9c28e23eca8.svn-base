package com.ibis.ibisecp2.utils;

/**
 * Created by danila on 24.11.16.
 */

public interface DistanceUtil {


    /**
     * Calculates geodetic distance between two points specified by latitude/longitude using Vincenty inverse formula
     * for ellipsoids
     *
     * @param lat1 first point latitude in decimal degrees
     * @param lon1 first point longitude in decimal degrees
     * @param lat2 second point latitude in decimal degrees
     * @param lon2 second point longitude in decimal degrees
     * @returns distance in meters between points with 5.10<sup>-4</sup> precision
     * @see <a href="http://www.movable-type.co.uk/scripts/latlong-vincenty.html">Originally posted here</a>
     */
    public double distVincenty(double lat1, double lon1, double lat2, double lon2);

    double distEuclidean(double x1, double y1, double x2, double y2);

    /**
     * Calculates geodetic distance between two points specified by latitude/longitude using Haversine formula
     *
     * @param lat1 first point latitude in decimal degrees
     * @param lon1 first point longitude in decimal degrees
     * @param lat2 second point latitude in decimal degrees
     * @param lon2 second point longitude in decimal degrees
     * @returns distance in meters between points with 0.3% precision
     */
    double distHaversine(double lat1, double lon1, double lat2, double lon2);
}
