package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.DataChoosePresenter;
import com.ibis.ibisecp2.presenters.impl.DataChoosePresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideDataChoosePresenterFactory
    implements Factory<DataChoosePresenter> {
  private final FragmentModule module;

  private final Provider<DataChoosePresenterImpl> presenterProvider;

  public FragmentModule_ProvideDataChoosePresenterFactory(
      FragmentModule module, Provider<DataChoosePresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public DataChoosePresenter get() {
    return Preconditions.checkNotNull(
        module.provideDataChoosePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DataChoosePresenter> create(
      FragmentModule module, Provider<DataChoosePresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideDataChoosePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideDataChoosePresenter(DataChoosePresenterImpl)}. */
  public static DataChoosePresenter proxyProvideDataChoosePresenter(
      FragmentModule instance, DataChoosePresenterImpl presenter) {
    return instance.provideDataChoosePresenter(presenter);
  }
}
