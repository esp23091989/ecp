package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import com.ibis.ibisecp2.model.FavoriteDoctor;
import com.ibis.ibisecp2.presenters.FavoritesDoctorsPresenter;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by comp on 21.04.17.
 */

public class FavoritesDoctorsPresenterImpl extends FavoritesDoctorsPresenter {

    private FavoritesDoctorsHelper mDoctorsHelper;

    @Inject
    public FavoritesDoctorsPresenterImpl(FavoritesDoctorsHelper doctorsHelper) {
        mDoctorsHelper = doctorsHelper;
    }

    @Override
    public void getDoctors() {
        unsubscribedSubscription();
        subscription = mDoctorsHelper.getDoctors().subscribe(
                new Observer<List<FavoriteDoctor>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<FavoriteDoctor> favoriteDoctors) {
                        Collections.reverse(favoriteDoctors);
                        view.showFavorites(favoriteDoctors);
                    }
                }
        );
    }

    @Override
    public void deleteDoctor(FavoriteDoctor favoriteDoctor) {
        unsubscribedSubscription();
        subscription = mDoctorsHelper.deleteFavoriteDoctor(favoriteDoctor)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        view.successDelete();
                    }
                });
    }
}
