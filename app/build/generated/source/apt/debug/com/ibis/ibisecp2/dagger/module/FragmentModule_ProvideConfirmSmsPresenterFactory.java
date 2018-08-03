package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.ConfirmSmsPresenter;
import com.ibis.ibisecp2.presenters.impl.ConfirmSmsPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideConfirmSmsPresenterFactory
    implements Factory<ConfirmSmsPresenter> {
  private final FragmentModule module;

  private final Provider<ConfirmSmsPresenterImpl> presenterProvider;

  public FragmentModule_ProvideConfirmSmsPresenterFactory(
      FragmentModule module, Provider<ConfirmSmsPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public ConfirmSmsPresenter get() {
    return Preconditions.checkNotNull(
        module.provideConfirmSmsPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ConfirmSmsPresenter> create(
      FragmentModule module, Provider<ConfirmSmsPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideConfirmSmsPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideConfirmSmsPresenter(ConfirmSmsPresenterImpl)}. */
  public static ConfirmSmsPresenter proxyProvideConfirmSmsPresenter(
      FragmentModule instance, ConfirmSmsPresenterImpl presenter) {
    return instance.provideConfirmSmsPresenter(presenter);
  }
}
