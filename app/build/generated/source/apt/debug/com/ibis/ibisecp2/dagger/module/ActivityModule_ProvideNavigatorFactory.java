package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.ui.Navigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideNavigatorFactory implements Factory<Navigator> {
  private final ActivityModule module;

  public ActivityModule_ProvideNavigatorFactory(ActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Navigator get() {
    return Preconditions.checkNotNull(
        module.provideNavigator(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Navigator> create(ActivityModule module) {
    return new ActivityModule_ProvideNavigatorFactory(module);
  }

  /** Proxies {@link ActivityModule#provideNavigator()}. */
  public static Navigator proxyProvideNavigator(ActivityModule instance) {
    return instance.provideNavigator();
  }
}
