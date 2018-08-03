package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.ui.Navigator;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginPresenterImpl__Factory implements Factory<LoginPresenterImpl_> {
  private final MembersInjector<LoginPresenterImpl_> loginPresenterImpl_MembersInjector;

  private final Provider<Navigator> navigatorProvider;

  public LoginPresenterImpl__Factory(
      MembersInjector<LoginPresenterImpl_> loginPresenterImpl_MembersInjector,
      Provider<Navigator> navigatorProvider) {
    assert loginPresenterImpl_MembersInjector != null;
    this.loginPresenterImpl_MembersInjector = loginPresenterImpl_MembersInjector;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public LoginPresenterImpl_ get() {
    return MembersInjectors.injectMembers(
        loginPresenterImpl_MembersInjector, new LoginPresenterImpl_(navigatorProvider.get()));
  }

  public static Factory<LoginPresenterImpl_> create(
      MembersInjector<LoginPresenterImpl_> loginPresenterImpl_MembersInjector,
      Provider<Navigator> navigatorProvider) {
    return new LoginPresenterImpl__Factory(loginPresenterImpl_MembersInjector, navigatorProvider);
  }
}
