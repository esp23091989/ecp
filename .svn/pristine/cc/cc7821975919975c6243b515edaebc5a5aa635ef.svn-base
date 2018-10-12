package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.RecipeLoaderHelper;
import com.ibis.ibisecp2.model.RecipeResponse;
import com.ibis.ibisecp2.retrofit.MedvedApi;
import com.ibis.ibisecp2.utils.RxUtil;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by danila on 23.12.15.
 */
public class RecipeLoaderHelperImpl implements RecipeLoaderHelper {
    private MedvedApi repository;
    private RxUtil rxUtil;

    @Inject
    public RecipeLoaderHelperImpl(MedvedApi repository, RxUtil rxUtil) {
        this.repository = repository;
        this.rxUtil = rxUtil;
    }

    @Override
    public Observable<RecipeResponse> getRecipe(String snils) {
        // tested snils - ("05466409471")
        return repository.getRecipe(snils).cache().compose(rxUtil.applySchedulers());
    }
}
