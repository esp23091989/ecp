package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginPresenterImpl_Factory implements Factory<LoginPresenterImpl> {
  private final MembersInjector<LoginPresenterImpl> loginPresenterImplMembersInjector;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<AuthHelper> authHelperProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public LoginPresenterImpl_Factory(
      MembersInjector<LoginPresenterImpl> loginPresenterImplMembersInjector,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<AuthHelper> authHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert loginPresenterImplMembersInjector != null;
    this.loginPresenterImplMembersInjector = loginPresenterImplMembersInjector;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert authHelperProvider != null;
    this.authHelperProvider = authHelperProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  @Override
  public LoginPresenterImpl get() {
    return MembersInjectors.injectMembers(
        loginPresenterImplMembersInjector,
        new LoginPresenterImpl(
            preferencesUtilsProvider.get(),
            navigatorProvider.get(),
            authHelperProvider.get(),
            patientHelperProvider.get(),
            dialogsHelperProvider.get()));
  }

  public static Factory<LoginPresenterImpl> create(
      MembersInjector<LoginPresenterImpl> loginPresenterImplMembersInjector,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<AuthHelper> authHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new LoginPresenterImpl_Factory(
        loginPresenterImplMembersInjector,
        preferencesUtilsProvider,
        navigatorProvider,
        authHelperProvider,
        patientHelperProvider,
        dialogsHelperProvider);
  }
}
