package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import com.ibis.ibisecp2.helpers.impl.VisitLoadHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideVisitLoadHelperFactory implements Factory<VisitLoadHelper> {
  private final HelperModule module;

  private final Provider<VisitLoadHelperImpl> helperProvider;

  public HelperModule_ProvideVisitLoadHelperFactory(
      HelperModule module, Provider<VisitLoadHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public VisitLoadHelper get() {
    return Preconditions.checkNotNull(
        module.provideVisitLoadHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<VisitLoadHelper> create(
      HelperModule module, Provider<VisitLoadHelperImpl> helperProvider) {
    return new HelperModule_ProvideVisitLoadHelperFactory(module, helperProvider);
  }
}
