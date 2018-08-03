package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.retrofit.MedvedApi;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RecipeLoaderHelperImpl_Factory implements Factory<RecipeLoaderHelperImpl> {
  private final Provider<MedvedApi> repositoryProvider;

  private final Provider<RxUtil> rxUtilProvider;

  public RecipeLoaderHelperImpl_Factory(
      Provider<MedvedApi> repositoryProvider, Provider<RxUtil> rxUtilProvider) {
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
  }

  @Override
  public RecipeLoaderHelperImpl get() {
    return new RecipeLoaderHelperImpl(repositoryProvider.get(), rxUtilProvider.get());
  }

  public static Factory<RecipeLoaderHelperImpl> create(
      Provider<MedvedApi> repositoryProvider, Provider<RxUtil> rxUtilProvider) {
    return new RecipeLoaderHelperImpl_Factory(repositoryProvider, rxUtilProvider);
  }
}
