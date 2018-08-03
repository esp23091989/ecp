package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.LoginPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
  private final Provider<LoginPresenter> loginPresenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  public LoginFragment_MembersInjector(
      Provider<LoginPresenter> loginPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider) {
    assert loginPresenterProvider != null;
    this.loginPresenterProvider = loginPresenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  public static MembersInjector<LoginFragment> create(
      Provider<LoginPresenter> loginPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider) {
    return new LoginFragment_MembersInjector(
        loginPresenterProvider, preferencesUtilsProvider, dialogsHelperProvider, navigatorProvider);
  }

  @Override
  public void injectMembers(LoginFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.loginPresenter = loginPresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.navigator = navigatorProvider.get();
  }

  public static void injectLoginPresenter(
      LoginFragment instance, Provider<LoginPresenter> loginPresenterProvider) {
    instance.loginPresenter = loginPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      LoginFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectDialogsHelper(
      LoginFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectNavigator(
      LoginFragment instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }
}
