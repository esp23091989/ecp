package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
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
public final class DoctorsPresenterImpl_Factory implements Factory<DoctorsPresenterImpl> {
  private final MembersInjector<DoctorsPresenterImpl> doctorsPresenterImplMembersInjector;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<DoctorLoaderHelper> doctorLoaderHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public DoctorsPresenterImpl_Factory(
      MembersInjector<DoctorsPresenterImpl> doctorsPresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert doctorsPresenterImplMembersInjector != null;
    this.doctorsPresenterImplMembersInjector = doctorsPresenterImplMembersInjector;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert doctorLoaderHelperProvider != null;
    this.doctorLoaderHelperProvider = doctorLoaderHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public DoctorsPresenterImpl get() {
    return MembersInjectors.injectMembers(
        doctorsPresenterImplMembersInjector,
        new DoctorsPresenterImpl(
            dialogsHelperProvider.get(),
            doctorLoaderHelperProvider.get(),
            navigatorProvider.get(),
            patientHelperProvider.get(),
            preferencesUtilsProvider.get()));
  }

  public static Factory<DoctorsPresenterImpl> create(
      MembersInjector<DoctorsPresenterImpl> doctorsPresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new DoctorsPresenterImpl_Factory(
        doctorsPresenterImplMembersInjector,
        dialogsHelperProvider,
        doctorLoaderHelperProvider,
        navigatorProvider,
        patientHelperProvider,
        preferencesUtilsProvider);
  }
}
