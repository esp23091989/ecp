package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.LocationHelper;
import com.ibis.ibisecp2.helpers.impl.LocationHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideLocationHelperFactory implements Factory<LocationHelper> {
  private final HelperModule module;

  private final Provider<LocationHelperImpl> helperProvider;

  public HelperModule_ProvideLocationHelperFactory(
      HelperModule module, Provider<LocationHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public LocationHelper get() {
    return Preconditions.checkNotNull(
        module.provideLocationHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LocationHelper> create(
      HelperModule module, Provider<LocationHelperImpl> helperProvider) {
    return new HelperModule_ProvideLocationHelperFactory(module, helperProvider);
  }
}
