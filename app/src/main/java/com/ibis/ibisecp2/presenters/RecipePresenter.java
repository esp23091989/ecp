package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.RecipeView;

/**
 * Created by danila on 08.08.16.
 */
public abstract class RecipePresenter extends BasePresenter<RecipeView> {
    public abstract void getRecipes();
}
