package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.VisitPresenter;
import com.ibis.ibisecp2.presenters.impl.VisitPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideVisitPresenterFactory implements Factory<VisitPresenter> {
  private final FragmentModule module;

  private final Provider<VisitPresenterImpl> presenterProvider;

  public FragmentModule_ProvideVisitPresenterFactory(
      FragmentModule module, Provider<VisitPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public VisitPresenter get() {
    return Preconditions.checkNotNull(
        module.provideVisitPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<VisitPresenter> create(
      FragmentModule module, Provider<VisitPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideVisitPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideVisitPresenter(VisitPresenterImpl)}. */
  public static VisitPresenter proxyProvideVisitPresenter(
      FragmentModule instance, VisitPresenterImpl presenter) {
    return instance.provideVisitPresenter(presenter);
  }
}
