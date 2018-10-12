package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.RecipeLoaderHelper;
import com.ibis.ibisecp2.model.Recipe;
import com.ibis.ibisecp2.model.RecipeResponse;
import com.ibis.ibisecp2.presenters.RecipePresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by danila on 08.08.16.
 */
public class RecipePresenterImpl extends RecipePresenter {

    private SharedPreferencesUtils preferencesUtils;
    private RecipeLoaderHelper loaderHelper;

    @Inject
    public RecipePresenterImpl(RecipeLoaderHelper loaderHelper,
                               SharedPreferencesUtils preferencesUtils) {
        this.loaderHelper = loaderHelper;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void getRecipes() {
        if (subscription != null) subscription.unsubscribe();
//        preferencesUtils.getPacient().getSnils().toString()
        subscription = loaderHelper.getRecipe(preferencesUtils.getSnils())
                .subscribe(new Observer<RecipeResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.showError();
                        }
                    }

                    @Override
                    public void onNext(RecipeResponse response) {
                        if (isViewAttached()) {
                            if (response.getRecipeList() != null &&
                                    response.getRecipeList().getRecipeList() != null) {
                                List<Recipe> recipeList = response.getRecipeList().getRecipeList();
                                Recipe.sortRecipeList(recipeList);
                                view.showRecipe(recipeList);
                            } else {
                                view.showError();
                            }
                        }
                    }
                });
    }
}
