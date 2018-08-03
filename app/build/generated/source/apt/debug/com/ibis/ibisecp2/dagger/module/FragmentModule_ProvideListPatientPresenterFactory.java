package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.ListPatientPresenter;
import com.ibis.ibisecp2.presenters.impl.ListPatientPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideListPatientPresenterFactory
    implements Factory<ListPatientPresenter> {
  private final FragmentModule module;

  private final Provider<ListPatientPresenterImpl> presenterProvider;

  public FragmentModule_ProvideListPatientPresenterFactory(
      FragmentModule module, Provider<ListPatientPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public ListPatientPresenter get() {
    return Preconditions.checkNotNull(
        module.provideListPatientPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ListPatientPresenter> create(
      FragmentModule module, Provider<ListPatientPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideListPatientPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideListPatientPresenter(ListPatientPresenterImpl)}. */
  public static ListPatientPresenter proxyProvideListPatientPresenter(
      FragmentModule instance, ListPatientPresenterImpl presenter) {
    return instance.provideListPatientPresenter(presenter);
  }
}
