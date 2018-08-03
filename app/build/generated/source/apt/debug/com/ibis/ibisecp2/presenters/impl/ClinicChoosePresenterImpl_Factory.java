package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.LocationHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.storage.Storage;
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
public final class ClinicChoosePresenterImpl_Factory implements Factory<ClinicChoosePresenterImpl> {
  private final MembersInjector<ClinicChoosePresenterImpl> clinicChoosePresenterImplMembersInjector;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<ClinicLoaderHelper> clinicLoaderHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<LocationHelper> locationHelperProvider;

  private final Provider<Storage> mStorageProvider;

  public ClinicChoosePresenterImpl_Factory(
      MembersInjector<ClinicChoosePresenterImpl> clinicChoosePresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<ClinicLoaderHelper> clinicLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<LocationHelper> locationHelperProvider,
      Provider<Storage> mStorageProvider) {
    assert clinicChoosePresenterImplMembersInjector != null;
    this.clinicChoosePresenterImplMembersInjector = clinicChoosePresenterImplMembersInjector;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert clinicLoaderHelperProvider != null;
    this.clinicLoaderHelperProvider = clinicLoaderHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert locationHelperProvider != null;
    this.locationHelperProvider = locationHelperProvider;
    assert mStorageProvider != null;
    this.mStorageProvider = mStorageProvider;
  }

  @Override
  public ClinicChoosePresenterImpl get() {
    return MembersInjectors.injectMembers(
        clinicChoosePresenterImplMembersInjector,
        new ClinicChoosePresenterImpl(
            dialogsHelperProvider.get(),
            preferencesUtilsProvider.get(),
            patientHelperProvider.get(),
            clinicLoaderHelperProvider.get(),
            navigatorProvider.get(),
            locationHelperProvider.get(),
            mStorageProvider.get()));
  }

  public static Factory<ClinicChoosePresenterImpl> create(
      MembersInjector<ClinicChoosePresenterImpl> clinicChoosePresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<ClinicLoaderHelper> clinicLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<LocationHelper> locationHelperProvider,
      Provider<Storage> mStorageProvider) {
    return new ClinicChoosePresenterImpl_Factory(
        clinicChoosePresenterImplMembersInjector,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        patientHelperProvider,
        clinicLoaderHelperProvider,
        navigatorProvider,
        locationHelperProvider,
        mStorageProvider);
  }
}
