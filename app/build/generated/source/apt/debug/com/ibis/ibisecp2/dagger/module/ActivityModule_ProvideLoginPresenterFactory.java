package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl_;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideLoginPresenterFactory implements Factory<LoginPresenter_> {
  private final ActivityModule module;

  private final Provider<LoginPresenterImpl_> presenterProvider;

  public ActivityModule_ProvideLoginPresenterFactory(
      ActivityModule module, Provider<LoginPresenterImpl_> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public LoginPresenter_ get() {
    return Preconditions.checkNotNull(
        module.provideLoginPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoginPresenter_> create(
      ActivityModule module, Provider<LoginPresenterImpl_> presenterProvider) {
    return new ActivityModule_ProvideLoginPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideLoginPresenter(LoginPresenterImpl_)}. */
  public static LoginPresenter_ proxyProvideLoginPresenter(
      ActivityModule instance, LoginPresenterImpl_ presenter) {
    return instance.provideLoginPresenter(presenter);
  }
}
