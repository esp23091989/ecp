package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ConfirmCodeHelper;
import com.ibis.ibisecp2.helpers.impl.ConfirmCodeHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideConfirmCodeHelperFactory
    implements Factory<ConfirmCodeHelper> {
  private final HelperModule module;

  private final Provider<ConfirmCodeHelperImpl> helperProvider;

  public HelperModule_ProvideConfirmCodeHelperFactory(
      HelperModule module, Provider<ConfirmCodeHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ConfirmCodeHelper get() {
    return Preconditions.checkNotNull(
        module.provideConfirmCodeHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ConfirmCodeHelper> create(
      HelperModule module, Provider<ConfirmCodeHelperImpl> helperProvider) {
    return new HelperModule_ProvideConfirmCodeHelperFactory(module, helperProvider);
  }
}
