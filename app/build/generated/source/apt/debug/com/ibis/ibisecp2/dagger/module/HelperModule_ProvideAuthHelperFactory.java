package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.impl.AuthHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideAuthHelperFactory implements Factory<AuthHelper> {
  private final HelperModule module;

  private final Provider<AuthHelperImpl> authHelperProvider;

  public HelperModule_ProvideAuthHelperFactory(
      HelperModule module, Provider<AuthHelperImpl> authHelperProvider) {
    assert module != null;
    this.module = module;
    assert authHelperProvider != null;
    this.authHelperProvider = authHelperProvider;
  }

  @Override
  public AuthHelper get() {
    return Preconditions.checkNotNull(
        module.provideAuthHelper(authHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AuthHelper> create(
      HelperModule module, Provider<AuthHelperImpl> authHelperProvider) {
    return new HelperModule_ProvideAuthHelperFactory(module, authHelperProvider);
  }
}
