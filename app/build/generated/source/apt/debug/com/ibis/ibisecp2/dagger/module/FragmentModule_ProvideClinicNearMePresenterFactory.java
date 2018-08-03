package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.ClinicNearMePresenter;
import com.ibis.ibisecp2.presenters.impl.ClinicNearMePresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideClinicNearMePresenterFactory
    implements Factory<ClinicNearMePresenter> {
  private final FragmentModule module;

  private final Provider<ClinicNearMePresenterImpl> presenterProvider;

  public FragmentModule_ProvideClinicNearMePresenterFactory(
      FragmentModule module, Provider<ClinicNearMePresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public ClinicNearMePresenter get() {
    return Preconditions.checkNotNull(
        module.provideClinicNearMePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ClinicNearMePresenter> create(
      FragmentModule module, Provider<ClinicNearMePresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideClinicNearMePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideClinicNearMePresenter(ClinicNearMePresenterImpl)}. */
  public static ClinicNearMePresenter proxyProvideClinicNearMePresenter(
      FragmentModule instance, ClinicNearMePresenterImpl presenter) {
    return instance.provideClinicNearMePresenter(presenter);
  }
}
