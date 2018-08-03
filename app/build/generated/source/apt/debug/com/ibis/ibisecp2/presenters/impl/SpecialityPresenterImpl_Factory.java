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
public final class SpecialityPresenterImpl_Factory implements Factory<SpecialityPresenterImpl> {
  private final MembersInjector<SpecialityPresenterImpl> specialityPresenterImplMembersInjector;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<DoctorLoaderHelper> doctorLoaderHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  public SpecialityPresenterImpl_Factory(
      MembersInjector<SpecialityPresenterImpl> specialityPresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider) {
    assert specialityPresenterImplMembersInjector != null;
    this.specialityPresenterImplMembersInjector = specialityPresenterImplMembersInjector;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert doctorLoaderHelperProvider != null;
    this.doctorLoaderHelperProvider = doctorLoaderHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
  }

  @Override
  public SpecialityPresenterImpl get() {
    return MembersInjectors.injectMembers(
        specialityPresenterImplMembersInjector,
        new SpecialityPresenterImpl(
            dialogsHelperProvider.get(),
            doctorLoaderHelperProvider.get(),
            navigatorProvider.get(),
            preferencesUtilsProvider.get(),
            patientHelperProvider.get()));
  }

  public static Factory<SpecialityPresenterImpl> create(
      MembersInjector<SpecialityPresenterImpl> specialityPresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PatientHelper> patientHelperProvider) {
    return new SpecialityPresenterImpl_Factory(
        specialityPresenterImplMembersInjector,
        dialogsHelperProvider,
        doctorLoaderHelperProvider,
        navigatorProvider,
        preferencesUtilsProvider,
        patientHelperProvider);
  }
}
