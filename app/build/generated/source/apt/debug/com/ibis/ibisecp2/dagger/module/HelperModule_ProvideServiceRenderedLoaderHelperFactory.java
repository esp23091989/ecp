package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ServiceRenderedLoaderHelper;
import com.ibis.ibisecp2.helpers.impl.ServiceRenderedLoaderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideServiceRenderedLoaderHelperFactory
    implements Factory<ServiceRenderedLoaderHelper> {
  private final HelperModule module;

  private final Provider<ServiceRenderedLoaderHelperImpl> helperProvider;

  public HelperModule_ProvideServiceRenderedLoaderHelperFactory(
      HelperModule module, Provider<ServiceRenderedLoaderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ServiceRenderedLoaderHelper get() {
    return Preconditions.checkNotNull(
        module.provideServiceRenderedLoaderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ServiceRenderedLoaderHelper> create(
      HelperModule module, Provider<ServiceRenderedLoaderHelperImpl> helperProvider) {
    return new HelperModule_ProvideServiceRenderedLoaderHelperFactory(module, helperProvider);
  }
}
