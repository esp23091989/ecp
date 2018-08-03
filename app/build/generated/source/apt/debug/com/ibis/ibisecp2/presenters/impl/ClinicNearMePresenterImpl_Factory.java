package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.DistanceUtil;
import com.ibis.ibisecp2.utils.RxUtil;
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
public final class ClinicNearMePresenterImpl_Factory implements Factory<ClinicNearMePresenterImpl> {
  private final MembersInjector<ClinicNearMePresenterImpl> clinicNearMePresenterImplMembersInjector;

  private final Provider<Storage> storageProvider;

  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<DistanceUtil> distanceUtilProvider;

  private final Provider<ClinicLoaderHelper> clinicLoaderHelperProvider;

  public ClinicNearMePresenterImpl_Factory(
      MembersInjector<ClinicNearMePresenterImpl> clinicNearMePresenterImplMembersInjector,
      Provider<Storage> storageProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DistanceUtil> distanceUtilProvider,
      Provider<ClinicLoaderHelper> clinicLoaderHelperProvider) {
    assert clinicNearMePresenterImplMembersInjector != null;
    this.clinicNearMePresenterImplMembersInjector = clinicNearMePresenterImplMembersInjector;
    assert storageProvider != null;
    this.storageProvider = storageProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert distanceUtilProvider != null;
    this.distanceUtilProvider = distanceUtilProvider;
    assert clinicLoaderHelperProvider != null;
    this.clinicLoaderHelperProvider = clinicLoaderHelperProvider;
  }

  @Override
  public ClinicNearMePresenterImpl get() {
    return MembersInjectors.injectMembers(
        clinicNearMePresenterImplMembersInjector,
        new ClinicNearMePresenterImpl(
            storageProvider.get(),
            rxUtilProvider.get(),
            preferencesUtilsProvider.get(),
            patientHelperProvider.get(),
            dialogsHelperProvider.get(),
            navigatorProvider.get(),
            distanceUtilProvider.get(),
            clinicLoaderHelperProvider.get()));
  }

  public static Factory<ClinicNearMePresenterImpl> create(
      MembersInjector<ClinicNearMePresenterImpl> clinicNearMePresenterImplMembersInjector,
      Provider<Storage> storageProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DistanceUtil> distanceUtilProvider,
      Provider<ClinicLoaderHelper> clinicLoaderHelperProvider) {
    return new ClinicNearMePresenterImpl_Factory(
        clinicNearMePresenterImplMembersInjector,
        storageProvider,
        rxUtilProvider,
        preferencesUtilsProvider,
        patientHelperProvider,
        dialogsHelperProvider,
        navigatorProvider,
        distanceUtilProvider,
        clinicLoaderHelperProvider);
  }
}
