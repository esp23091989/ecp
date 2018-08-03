package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.impl.DoctorLoaderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideDoctorLoaderHelperFactory
    implements Factory<DoctorLoaderHelper> {
  private final HelperModule module;

  private final Provider<DoctorLoaderHelperImpl> helperProvider;

  public HelperModule_ProvideDoctorLoaderHelperFactory(
      HelperModule module, Provider<DoctorLoaderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public DoctorLoaderHelper get() {
    return Preconditions.checkNotNull(
        module.provideDoctorLoaderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DoctorLoaderHelper> create(
      HelperModule module, Provider<DoctorLoaderHelperImpl> helperProvider) {
    return new HelperModule_ProvideDoctorLoaderHelperFactory(module, helperProvider);
  }
}
