package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.model.FavoriteDoctor;
import com.ibis.ibisecp2.ui.view.FavoritesDoctorsView;

/**
 * Created by comp on 21.04.17.
 */

public abstract class FavoritesDoctorsPresenter extends BasePresenter<FavoritesDoctorsView> {
    public abstract void getDoctors();

    public abstract void deleteDoctor(FavoriteDoctor favoriteDoctor);
}
