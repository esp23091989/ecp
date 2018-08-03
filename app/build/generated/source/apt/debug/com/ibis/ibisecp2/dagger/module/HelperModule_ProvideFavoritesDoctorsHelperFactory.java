package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import com.ibis.ibisecp2.helpers.impl.FavoritesDoctorsHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideFavoritesDoctorsHelperFactory
    implements Factory<FavoritesDoctorsHelper> {
  private final HelperModule module;

  private final Provider<FavoritesDoctorsHelperImpl> helperProvider;

  public HelperModule_ProvideFavoritesDoctorsHelperFactory(
      HelperModule module, Provider<FavoritesDoctorsHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public FavoritesDoctorsHelper get() {
    return Preconditions.checkNotNull(
        module.provideFavoritesDoctorsHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<FavoritesDoctorsHelper> create(
      HelperModule module, Provider<FavoritesDoctorsHelperImpl> helperProvider) {
    return new HelperModule_ProvideFavoritesDoctorsHelperFactory(module, helperProvider);
  }
}
