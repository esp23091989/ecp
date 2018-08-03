package com.ibis.ibisecp2.presenters.impl;

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
public final class StartPresenterImpl_Factory implements Factory<StartPresenterImpl> {
  private final MembersInjector<StartPresenterImpl> startPresenterImplMembersInjector;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  public StartPresenterImpl_Factory(
      MembersInjector<StartPresenterImpl> startPresenterImplMembersInjector,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<Navigator> navigatorProvider) {
    assert startPresenterImplMembersInjector != null;
    this.startPresenterImplMembersInjector = startPresenterImplMembersInjector;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public StartPresenterImpl get() {
    return MembersInjectors.injectMembers(
        startPresenterImplMembersInjector,
        new StartPresenterImpl(
            preferencesUtilsProvider.get(),
            dialogsHelperProvider.get(),
            patientHelperProvider.get(),
            navigatorProvider.get()));
  }

  public static Factory<StartPresenterImpl> create(
      MembersInjector<StartPresenterImpl> startPresenterImplMembersInjector,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<Navigator> navigatorProvider) {
    return new StartPresenterImpl_Factory(
        startPresenterImplMembersInjector,
        preferencesUtilsProvider,
        dialogsHelperProvider,
        patientHelperProvider,
        navigatorProvider);
  }
}
