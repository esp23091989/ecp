package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.LoginPresenter;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideLoginPresenterFactory implements Factory<LoginPresenter> {
  private final FragmentModule module;

  private final Provider<LoginPresenterImpl> presenterProvider;

  public FragmentModule_ProvideLoginPresenterFactory(
      FragmentModule module, Provider<LoginPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public LoginPresenter get() {
    return Preconditions.checkNotNull(
        module.provideLoginPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoginPresenter> create(
      FragmentModule module, Provider<LoginPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideLoginPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideLoginPresenter(LoginPresenterImpl)}. */
  public static LoginPresenter proxyProvideLoginPresenter(
      FragmentModule instance, LoginPresenterImpl presenter) {
    return instance.provideLoginPresenter(presenter);
  }
}
