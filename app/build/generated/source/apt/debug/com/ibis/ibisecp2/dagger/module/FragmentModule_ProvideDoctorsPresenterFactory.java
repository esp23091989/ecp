package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.DoctorsPresenter;
import com.ibis.ibisecp2.presenters.impl.DoctorsPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideDoctorsPresenterFactory
    implements Factory<DoctorsPresenter> {
  private final FragmentModule module;

  private final Provider<DoctorsPresenterImpl> presenterProvider;

  public FragmentModule_ProvideDoctorsPresenterFactory(
      FragmentModule module, Provider<DoctorsPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public DoctorsPresenter get() {
    return Preconditions.checkNotNull(
        module.provideDoctorsPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DoctorsPresenter> create(
      FragmentModule module, Provider<DoctorsPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideDoctorsPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideDoctorsPresenter(DoctorsPresenterImpl)}. */
  public static DoctorsPresenter proxyProvideDoctorsPresenter(
      FragmentModule instance, DoctorsPresenterImpl presenter) {
    return instance.provideDoctorsPresenter(presenter);
  }
}
