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
public final class PersonalPresenterImpl_Factory implements Factory<PersonalPresenterImpl> {
  private final MembersInjector<PersonalPresenterImpl> personalPresenterImplMembersInjector;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public PersonalPresenterImpl_Factory(
      MembersInjector<PersonalPresenterImpl> personalPresenterImplMembersInjector,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert personalPresenterImplMembersInjector != null;
    this.personalPresenterImplMembersInjector = personalPresenterImplMembersInjector;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public PersonalPresenterImpl get() {
    return MembersInjectors.injectMembers(
        personalPresenterImplMembersInjector,
        new PersonalPresenterImpl(patientHelperProvider.get(), preferencesUtilsProvider.get()));
  }

  public static Factory<PersonalPresenterImpl> create(
      MembersInjector<PersonalPresenterImpl> personalPresenterImplMembersInjector,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new PersonalPresenterImpl_Factory(
        personalPresenterImplMembersInjector, patientHelperProvider, preferencesUtilsProvider);
  }
}
