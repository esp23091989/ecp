package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.HistoryPresenter;
import com.ibis.ibisecp2.presenters.impl.HistoryPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideHistoryPresenterFactory
    implements Factory<HistoryPresenter> {
  private final FragmentModule module;

  private final Provider<HistoryPresenterImpl> presenterProvider;

  public FragmentModule_ProvideHistoryPresenterFactory(
      FragmentModule module, Provider<HistoryPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public HistoryPresenter get() {
    return Preconditions.checkNotNull(
        module.provideHistoryPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HistoryPresenter> create(
      FragmentModule module, Provider<HistoryPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideHistoryPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideHistoryPresenter(HistoryPresenterImpl)}. */
  public static HistoryPresenter proxyProvideHistoryPresenter(
      FragmentModule instance, HistoryPresenterImpl presenter) {
    return instance.provideHistoryPresenter(presenter);
  }
}
