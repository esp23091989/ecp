package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.impl.ChangeVisitHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideEnrollHelperFactory implements Factory<ChangeVisitHelper> {
  private final HelperModule module;

  private final Provider<ChangeVisitHelperImpl> helperProvider;

  public HelperModule_ProvideEnrollHelperFactory(
      HelperModule module, Provider<ChangeVisitHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ChangeVisitHelper get() {
    return Preconditions.checkNotNull(
        module.provideEnrollHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ChangeVisitHelper> create(
      HelperModule module, Provider<ChangeVisitHelperImpl> helperProvider) {
    return new HelperModule_ProvideEnrollHelperFactory(module, helperProvider);
  }
}
