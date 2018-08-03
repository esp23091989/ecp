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
public final class ConfirmSmsPresenterImpl_Factory implements Factory<ConfirmSmsPresenterImpl> {
  private final MembersInjector<ConfirmSmsPresenterImpl> confirmSmsPresenterImplMembersInjector;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<AuthHelper> authHelperProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public ConfirmSmsPresenterImpl_Factory(
      MembersInjector<ConfirmSmsPresenterImpl> confirmSmsPresenterImplMembersInjector,
      Provider<Navigator> navigatorProvider,
      Provider<AuthHelper> authHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert confirmSmsPresenterImplMembersInjector != null;
    this.confirmSmsPresenterImplMembersInjector = confirmSmsPresenterImplMembersInjector;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert authHelperProvider != null;
    this.authHelperProvider = authHelperProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  @Override
  public ConfirmSmsPresenterImpl get() {
    return MembersInjectors.injectMembers(
        confirmSmsPresenterImplMembersInjector,
        new ConfirmSmsPresenterImpl(
            navigatorProvider.get(),
            authHelperProvider.get(),
            patientHelperProvider.get(),
            preferencesUtilsProvider.get(),
            dialogsHelperProvider.get()));
  }

  public static Factory<ConfirmSmsPresenterImpl> create(
      MembersInjector<ConfirmSmsPresenterImpl> confirmSmsPresenterImplMembersInjector,
      Provider<Navigator> navigatorProvider,
      Provider<AuthHelper> authHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new ConfirmSmsPresenterImpl_Factory(
        confirmSmsPresenterImplMembersInjector,
        navigatorProvider,
        authHelperProvider,
        patientHelperProvider,
        preferencesUtilsProvider,
        dialogsHelperProvider);
  }
}
