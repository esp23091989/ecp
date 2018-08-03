package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.RecipeLoaderHelper;
import com.ibis.ibisecp2.helpers.impl.RecipeLoaderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideRecipeLoaderHelperFactory
    implements Factory<RecipeLoaderHelper> {
  private final HelperModule module;

  private final Provider<RecipeLoaderHelperImpl> helperProvider;

  public HelperModule_ProvideRecipeLoaderHelperFactory(
      HelperModule module, Provider<RecipeLoaderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public RecipeLoaderHelper get() {
    return Preconditions.checkNotNull(
        module.provideRecipeLoaderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RecipeLoaderHelper> create(
      HelperModule module, Provider<RecipeLoaderHelperImpl> helperProvider) {
    return new HelperModule_ProvideRecipeLoaderHelperFactory(module, helperProvider);
  }
}
