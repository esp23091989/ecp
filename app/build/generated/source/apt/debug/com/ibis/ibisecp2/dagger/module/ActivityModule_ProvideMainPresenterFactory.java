package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.MainPresenter;
import com.ibis.ibisecp2.presenters.impl.MainPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideMainPresenterFactory implements Factory<MainPresenter> {
  private final ActivityModule module;

  private final Provider<MainPresenterImpl> presenterProvider;

  public ActivityModule_ProvideMainPresenterFactory(
      ActivityModule module, Provider<MainPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public MainPresenter get() {
    return Preconditions.checkNotNull(
        module.provideMainPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MainPresenter> create(
      ActivityModule module, Provider<MainPresenterImpl> presenterProvider) {
    return new ActivityModule_ProvideMainPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideMainPresenter(MainPresenterImpl)}. */
  public static MainPresenter proxyProvideMainPresenter(
      ActivityModule instance, MainPresenterImpl presenter) {
    return instance.provideMainPresenter(presenter);
  }
}
