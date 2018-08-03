package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import com.ibis.ibisecp2.model.FavoriteDoctor;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by comp on 21.04.17.
 */

public class FavoritesDoctorsHelperImpl implements FavoritesDoctorsHelper {

    private RxUtil rxUtil;
    private Storage storage;

    @Inject
    public FavoritesDoctorsHelperImpl(RxUtil rxUtil, Storage storage) {
        this.rxUtil = rxUtil;
        this.storage = storage;
    }

    @Override
    public Observable<List<FavoriteDoctor>> getDoctors() {
        return storage.getArrayListFromDb(FavoriteDoctor.class).compose(rxUtil.applySchedulers());
    }

    @Override
    public Observable<Boolean> saveFavoriteDoctor(FavoriteDoctor favoriteDoctor) {
        return storage.saveItemInDb(favoriteDoctor);
    }

    @Override
    public Observable<Boolean> deleteFavoriteDoctor(FavoriteDoctor favoriteDoctor) {
        return storage.deleteItemInDb(favoriteDoctor);
    }

    @Override
    public Observable<FavoriteDoctor> getFavoriteDoctorById(long id) {
        return storage.getObjectById(FavoriteDoctor.class, id).compose(rxUtil.applySchedulers());
    }

}
