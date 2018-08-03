package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.ClinicChoosePresenter;
import com.ibis.ibisecp2.presenters.impl.ClinicChoosePresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideClinicChoosePresenterFactory
    implements Factory<ClinicChoosePresenter> {
  private final FragmentModule module;

  private final Provider<ClinicChoosePresenterImpl> presenterProvider;

  public FragmentModule_ProvideClinicChoosePresenterFactory(
      FragmentModule module, Provider<ClinicChoosePresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public ClinicChoosePresenter get() {
    return Preconditions.checkNotNull(
        module.provideClinicChoosePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ClinicChoosePresenter> create(
      FragmentModule module, Provider<ClinicChoosePresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideClinicChoosePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideClinicChoosePresenter(ClinicChoosePresenterImpl)}. */
  public static ClinicChoosePresenter proxyProvideClinicChoosePresenter(
      FragmentModule instance, ClinicChoosePresenterImpl presenter) {
    return instance.provideClinicChoosePresenter(presenter);
  }
}
