package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.PatientHelper;
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
public final class MainPresenterImpl_Factory implements Factory<MainPresenterImpl> {
  private final MembersInjector<MainPresenterImpl> mainPresenterImplMembersInjector;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public MainPresenterImpl_Factory(
      MembersInjector<MainPresenterImpl> mainPresenterImplMembersInjector,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert mainPresenterImplMembersInjector != null;
    this.mainPresenterImplMembersInjector = mainPresenterImplMembersInjector;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public MainPresenterImpl get() {
    return MembersInjectors.injectMembers(
        mainPresenterImplMembersInjector,
        new MainPresenterImpl(patientHelperProvider.get(), preferencesUtilsProvider.get()));
  }

  public static Factory<MainPresenterImpl> create(
      MembersInjector<MainPresenterImpl> mainPresenterImplMembersInjector,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new MainPresenterImpl_Factory(
        mainPresenterImplMembersInjector, patientHelperProvider, preferencesUtilsProvider);
  }
}
