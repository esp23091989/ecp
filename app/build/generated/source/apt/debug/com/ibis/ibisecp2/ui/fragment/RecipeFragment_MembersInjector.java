package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.presenters.RecipePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RecipeFragment_MembersInjector implements MembersInjector<RecipeFragment> {
  private final Provider<RecipePresenter> recipePresenterProvider;

  public RecipeFragment_MembersInjector(Provider<RecipePresenter> recipePresenterProvider) {
    assert recipePresenterProvider != null;
    this.recipePresenterProvider = recipePresenterProvider;
  }

  public static MembersInjector<RecipeFragment> create(
      Provider<RecipePresenter> recipePresenterProvider) {
    return new RecipeFragment_MembersInjector(recipePresenterProvider);
  }

  @Override
  public void injectMembers(RecipeFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.recipePresenter = recipePresenterProvider.get();
  }

  public static void injectRecipePresenter(
      RecipeFragment instance, Provider<RecipePresenter> recipePresenterProvider) {
    instance.recipePresenter = recipePresenterProvider.get();
  }
}
