package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.helpers.impl.PatientHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvidePatientHelperFactory implements Factory<PatientHelper> {
  private final HelperModule module;

  private final Provider<PatientHelperImpl> helperProvider;

  public HelperModule_ProvidePatientHelperFactory(
      HelperModule module, Provider<PatientHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public PatientHelper get() {
    return Preconditions.checkNotNull(
        module.providePatientHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PatientHelper> create(
      HelperModule module, Provider<PatientHelperImpl> helperProvider) {
    return new HelperModule_ProvidePatientHelperFactory(module, helperProvider);
  }
}
