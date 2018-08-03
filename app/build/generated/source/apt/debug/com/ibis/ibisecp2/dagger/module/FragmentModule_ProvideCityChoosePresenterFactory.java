package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.CityChoosePresenter;
import com.ibis.ibisecp2.presenters.impl.CityChoosePresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideCityChoosePresenterFactory
    implements Factory<CityChoosePresenter> {
  private final FragmentModule module;

  private final Provider<CityChoosePresenterImpl> presenterProvider;

  public FragmentModule_ProvideCityChoosePresenterFactory(
      FragmentModule module, Provider<CityChoosePresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public CityChoosePresenter get() {
    return Preconditions.checkNotNull(
        module.provideCityChoosePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CityChoosePresenter> create(
      FragmentModule module, Provider<CityChoosePresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideCityChoosePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideCityChoosePresenter(CityChoosePresenterImpl)}. */
  public static CityChoosePresenter proxyProvideCityChoosePresenter(
      FragmentModule instance, CityChoosePresenterImpl presenter) {
    return instance.provideCityChoosePresenter(presenter);
  }
}
