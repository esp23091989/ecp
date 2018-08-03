package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.TestPostHelper;
import com.ibis.ibisecp2.helpers.impl.TestPostHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideTestPostHelperFactory implements Factory<TestPostHelper> {
  private final HelperModule module;

  private final Provider<TestPostHelperImpl> helperProvider;

  public HelperModule_ProvideTestPostHelperFactory(
      HelperModule module, Provider<TestPostHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public TestPostHelper get() {
    return Preconditions.checkNotNull(
        module.provideTestPostHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TestPostHelper> create(
      HelperModule module, Provider<TestPostHelperImpl> helperProvider) {
    return new HelperModule_ProvideTestPostHelperFactory(module, helperProvider);
  }
}
