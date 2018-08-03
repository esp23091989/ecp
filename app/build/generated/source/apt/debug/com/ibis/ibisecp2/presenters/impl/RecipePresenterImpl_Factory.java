package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.RecipeLoaderHelper;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RecipePresenterImpl_Factory implements Factory<RecipePresenterImpl> {
  private final MembersInjector<RecipePresenterImpl> recipePresenterImplMembersInjector;

  private final Provider<RecipeLoaderHelper> loaderHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public RecipePresenterImpl_Factory(
      MembersInjector<RecipePresenterImpl> recipePresenterImplMembersInjector,
      Provider<RecipeLoaderHelper> loaderHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert recipePresenterImplMembersInjector != null;
    this.recipePresenterImplMembersInjector = recipePresenterImplMembersInjector;
    assert loaderHelperProvider != null;
    this.loaderHelperProvider = loaderHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public RecipePresenterImpl get() {
    return MembersInjectors.injectMembers(
        recipePresenterImplMembersInjector,
        new RecipePresenterImpl(loaderHelperProvider.get(), preferencesUtilsProvider.get()));
  }

  public static Factory<RecipePresenterImpl> create(
      MembersInjector<RecipePresenterImpl> recipePresenterImplMembersInjector,
      Provider<RecipeLoaderHelper> loaderHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new RecipePresenterImpl_Factory(
        recipePresenterImplMembersInjector, loaderHelperProvider, preferencesUtilsProvider);
  }
}
