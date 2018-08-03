package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.CityLoaderHelper;
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
public final class CityChoosePresenterImpl_Factory implements Factory<CityChoosePresenterImpl> {
  private final MembersInjector<CityChoosePresenterImpl> cityChoosePresenterImplMembersInjector;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<CityLoaderHelper> cityLoaderHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  public CityChoosePresenterImpl_Factory(
      MembersInjector<CityChoosePresenterImpl> cityChoosePresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<CityLoaderHelper> cityLoaderHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<Navigator> navigatorProvider) {
    assert cityChoosePresenterImplMembersInjector != null;
    this.cityChoosePresenterImplMembersInjector = cityChoosePresenterImplMembersInjector;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert cityLoaderHelperProvider != null;
    this.cityLoaderHelperProvider = cityLoaderHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public CityChoosePresenterImpl get() {
    return MembersInjectors.injectMembers(
        cityChoosePresenterImplMembersInjector,
        new CityChoosePresenterImpl(
            dialogsHelperProvider.get(),
            cityLoaderHelperProvider.get(),
            preferencesUtilsProvider.get(),
            patientHelperProvider.get(),
            navigatorProvider.get()));
  }

  public static Factory<CityChoosePresenterImpl> create(
      MembersInjector<CityChoosePresenterImpl> cityChoosePresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<CityLoaderHelper> cityLoaderHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<Navigator> navigatorProvider) {
    return new CityChoosePresenterImpl_Factory(
        cityChoosePresenterImplMembersInjector,
        dialogsHelperProvider,
        cityLoaderHelperProvider,
        preferencesUtilsProvider,
        patientHelperProvider,
        navigatorProvider);
  }
}
