package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.helpers.RecipeLoaderHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Recipe;
import com.ibis.ibisecp2.model.RecipeList;
import com.ibis.ibisecp2.model.RecipeResponse;
import com.ibis.ibisecp2.presenters.impl.RecipePresenterImpl;
import com.ibis.ibisecp2.ui.view.RecipeView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by danila on 28.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class RecipePresenterTest {

    @Mock
    SharedPreferencesUtils preferencesUtils;
    @Mock
    RecipeLoaderHelper loaderHelper;
    @Mock
    RecipeView recipeView;

    private RecipePresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new RecipePresenterImpl(loaderHelper, preferencesUtils);
        presenter.attachView(recipeView);
    }

    @Test
    public void getRecipes() throws Exception {
        RecipeResponse recipeResponse = new RecipeResponse();
        List<Recipe> recipes = new ArrayList<Recipe>();
        recipes.add(new Recipe());
        RecipeList recipeList = new RecipeList();
        recipeList.setRecipeList(recipes);
        recipeResponse.setRecipeList(recipeList);
        Patient patient = new Patient();
        patient.set_id(123456789L);
        when(preferencesUtils.getPacient()).thenReturn(spy(patient));
        when(preferencesUtils.getPacient().get_id()).thenReturn(patient.get_id());
        when(loaderHelper.getRecipe("123456789")).thenReturn(Observable.just(recipeResponse));

        presenter.getRecipes();

        ArgumentCaptor<List<Recipe>> captor = new ArgumentCaptor<>();
        verify(recipeView, never()).showError();
        verify(recipeView).showRecipe(captor.capture());
        assertEquals(recipes.size(), captor.getValue().size());
    }

}