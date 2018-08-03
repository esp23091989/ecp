package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.FavoriteDoctor;

import java.util.List;

/**
 * Created by comp on 21.04.17.
 */

public interface FavoritesDoctorsView {
    void showFavorites(List<FavoriteDoctor> favoriteDoctors);

    void successDelete();
}
