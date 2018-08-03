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
public final class LocationPresenterImpl_Factory implements Factory<LocationPresenterImpl> {
  private final MembersInjector<LocationPresenterImpl> locationPresenterImplMembersInjector;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public LocationPresenterImpl_Factory(
      MembersInjector<LocationPresenterImpl> locationPresenterImplMembersInjector,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert locationPresenterImplMembersInjector != null;
    this.locationPresenterImplMembersInjector = locationPresenterImplMembersInjector;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public LocationPresenterImpl get() {
    return MembersInjectors.injectMembers(
        locationPresenterImplMembersInjector,
        new LocationPresenterImpl(patientHelperProvider.get(), preferencesUtilsProvider.get()));
  }

  public static Factory<LocationPresenterImpl> create(
      MembersInjector<LocationPresenterImpl> locationPresenterImplMembersInjector,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new LocationPresenterImpl_Factory(
        locationPresenterImplMembersInjector, patientHelperProvider, preferencesUtilsProvider);
  }
}
