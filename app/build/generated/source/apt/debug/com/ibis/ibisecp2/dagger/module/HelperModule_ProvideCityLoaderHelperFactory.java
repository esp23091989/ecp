package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.CityLoaderHelper;
import com.ibis.ibisecp2.helpers.impl.CityLoaderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideCityLoaderHelperFactory
    implements Factory<CityLoaderHelper> {
  private final HelperModule module;

  private final Provider<CityLoaderHelperImpl> helperProvider;

  public HelperModule_ProvideCityLoaderHelperFactory(
      HelperModule module, Provider<CityLoaderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public CityLoaderHelper get() {
    return Preconditions.checkNotNull(
        module.provideCityLoaderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CityLoaderHelper> create(
      HelperModule module, Provider<CityLoaderHelperImpl> helperProvider) {
    return new HelperModule_ProvideCityLoaderHelperFactory(module, helperProvider);
  }
}
