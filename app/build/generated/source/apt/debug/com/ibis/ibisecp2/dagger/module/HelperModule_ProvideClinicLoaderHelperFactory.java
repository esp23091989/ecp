package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.impl.ClinicLoaderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideClinicLoaderHelperFactory
    implements Factory<ClinicLoaderHelper> {
  private final HelperModule module;

  private final Provider<ClinicLoaderHelperImpl> helperProvider;

  public HelperModule_ProvideClinicLoaderHelperFactory(
      HelperModule module, Provider<ClinicLoaderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ClinicLoaderHelper get() {
    return Preconditions.checkNotNull(
        module.provideClinicLoaderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ClinicLoaderHelper> create(
      HelperModule module, Provider<ClinicLoaderHelperImpl> helperProvider) {
    return new HelperModule_ProvideClinicLoaderHelperFactory(module, helperProvider);
  }
}
