package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.MedicamentFindHelper;
import com.ibis.ibisecp2.helpers.impl.MedicamentFindHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideMedicamentFindHelperFactory
    implements Factory<MedicamentFindHelper> {
  private final HelperModule module;

  private final Provider<MedicamentFindHelperImpl> helperProvider;

  public HelperModule_ProvideMedicamentFindHelperFactory(
      HelperModule module, Provider<MedicamentFindHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public MedicamentFindHelper get() {
    return Preconditions.checkNotNull(
        module.provideMedicamentFindHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MedicamentFindHelper> create(
      HelperModule module, Provider<MedicamentFindHelperImpl> helperProvider) {
    return new HelperModule_ProvideMedicamentFindHelperFactory(module, helperProvider);
  }
}
