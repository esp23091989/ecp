package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.RegistryPagerPresenter;
import com.ibis.ibisecp2.presenters.impl.RegistryPagerPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideRegistryPagerPresenterFactory
    implements Factory<RegistryPagerPresenter> {
  private final ActivityModule module;

  private final Provider<RegistryPagerPresenterImpl> presenterProvider;

  public ActivityModule_ProvideRegistryPagerPresenterFactory(
      ActivityModule module, Provider<RegistryPagerPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public RegistryPagerPresenter get() {
    return Preconditions.checkNotNull(
        module.provideRegistryPagerPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RegistryPagerPresenter> create(
      ActivityModule module, Provider<RegistryPagerPresenterImpl> presenterProvider) {
    return new ActivityModule_ProvideRegistryPagerPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideRegistryPagerPresenter(RegistryPagerPresenterImpl)}. */
  public static RegistryPagerPresenter proxyProvideRegistryPagerPresenter(
      ActivityModule instance, RegistryPagerPresenterImpl presenter) {
    return instance.provideRegistryPagerPresenter(presenter);
  }
}
