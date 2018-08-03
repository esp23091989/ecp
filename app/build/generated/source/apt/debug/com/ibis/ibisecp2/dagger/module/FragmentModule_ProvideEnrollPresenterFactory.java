package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.CreateVisitPresenter;
import com.ibis.ibisecp2.presenters.impl.CreateVisitPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideEnrollPresenterFactory
    implements Factory<CreateVisitPresenter> {
  private final FragmentModule module;

  private final Provider<CreateVisitPresenterImpl> presenterProvider;

  public FragmentModule_ProvideEnrollPresenterFactory(
      FragmentModule module, Provider<CreateVisitPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public CreateVisitPresenter get() {
    return Preconditions.checkNotNull(
        module.provideEnrollPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CreateVisitPresenter> create(
      FragmentModule module, Provider<CreateVisitPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideEnrollPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideEnrollPresenter(CreateVisitPresenterImpl)}. */
  public static CreateVisitPresenter proxyProvideEnrollPresenter(
      FragmentModule instance, CreateVisitPresenterImpl presenter) {
    return instance.provideEnrollPresenter(presenter);
  }
}
