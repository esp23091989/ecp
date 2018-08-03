package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.Recipe;

import java.util.List;

/**
 * Created by danila on 08.08.16.
 */
public interface RecipeView {
    void showRecipe(List<Recipe> recipeList);

    void showError();
}
