package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.LocationPresenter;
import com.ibis.ibisecp2.presenters.impl.LocationPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideLocationPresenterFactory
    implements Factory<LocationPresenter> {
  private final FragmentModule module;

  private final Provider<LocationPresenterImpl> presenterProvider;

  public FragmentModule_ProvideLocationPresenterFactory(
      FragmentModule module, Provider<LocationPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public LocationPresenter get() {
    return Preconditions.checkNotNull(
        module.provideLocationPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LocationPresenter> create(
      FragmentModule module, Provider<LocationPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideLocationPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideLocationPresenter(LocationPresenterImpl)}. */
  public static LocationPresenter proxyProvideLocationPresenter(
      FragmentModule instance, LocationPresenterImpl presenter) {
    return instance.provideLocationPresenter(presenter);
  }
}
