package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.FavoriteDoctor;

import java.util.List;

import rx.Observable;

/**
 * Created by comp on 21.04.17.
 */

public interface FavoritesDoctorsHelper {
    Observable<List<FavoriteDoctor>> getDoctors();

    Observable<Boolean> saveFavoriteDoctor(FavoriteDoctor favoriteDoctor);

    Observable<Boolean> deleteFavoriteDoctor(FavoriteDoctor favoriteDoctor);

    Observable<FavoriteDoctor> getFavoriteDoctorById(long id);
}
