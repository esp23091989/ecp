package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.StartPresenter;
import com.ibis.ibisecp2.presenters.impl.StartPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideStartPresenterFactory implements Factory<StartPresenter> {
  private final ActivityModule module;

  private final Provider<StartPresenterImpl> presenterProvider;

  public ActivityModule_ProvideStartPresenterFactory(
      ActivityModule module, Provider<StartPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public StartPresenter get() {
    return Preconditions.checkNotNull(
        module.provideStartPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<StartPresenter> create(
      ActivityModule module, Provider<StartPresenterImpl> presenterProvider) {
    return new ActivityModule_ProvideStartPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideStartPresenter(StartPresenterImpl)}. */
  public static StartPresenter proxyProvideStartPresenter(
      ActivityModule instance, StartPresenterImpl presenter) {
    return instance.provideStartPresenter(presenter);
  }
}
