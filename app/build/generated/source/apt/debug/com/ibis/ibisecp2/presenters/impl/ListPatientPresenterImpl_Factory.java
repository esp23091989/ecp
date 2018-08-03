package com.ibis.ibisecp2.presenters.impl;

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
public final class ListPatientPresenterImpl_Factory implements Factory<ListPatientPresenterImpl> {
  private final MembersInjector<ListPatientPresenterImpl> listPatientPresenterImplMembersInjector;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  public ListPatientPresenterImpl_Factory(
      MembersInjector<ListPatientPresenterImpl> listPatientPresenterImplMembersInjector,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<PatientHelper> patientHelperProvider) {
    assert listPatientPresenterImplMembersInjector != null;
    this.listPatientPresenterImplMembersInjector = listPatientPresenterImplMembersInjector;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
  }

  @Override
  public ListPatientPresenterImpl get() {
    return MembersInjectors.injectMembers(
        listPatientPresenterImplMembersInjector,
        new ListPatientPresenterImpl(
            preferencesUtilsProvider.get(), navigatorProvider.get(), patientHelperProvider.get()));
  }

  public static Factory<ListPatientPresenterImpl> create(
      MembersInjector<ListPatientPresenterImpl> listPatientPresenterImplMembersInjector,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<PatientHelper> patientHelperProvider) {
    return new ListPatientPresenterImpl_Factory(
        listPatientPresenterImplMembersInjector,
        preferencesUtilsProvider,
        navigatorProvider,
        patientHelperProvider);
  }
}
