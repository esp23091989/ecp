package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
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
public final class CreateVisitPresenterImpl_Factory implements Factory<CreateVisitPresenterImpl> {
  private final MembersInjector<CreateVisitPresenterImpl> createVisitPresenterImplMembersInjector;

  private final Provider<ChangeVisitHelper> changeVisitHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<FavoritesDoctorsHelper> favoritesDoctorsHelperProvider;

  private final Provider<DoctorLoaderHelper> doctorLoaderHelperProvider;

  public CreateVisitPresenterImpl_Factory(
      MembersInjector<CreateVisitPresenterImpl> createVisitPresenterImplMembersInjector,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<FavoritesDoctorsHelper> favoritesDoctorsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider) {
    assert createVisitPresenterImplMembersInjector != null;
    this.createVisitPresenterImplMembersInjector = createVisitPresenterImplMembersInjector;
    assert changeVisitHelperProvider != null;
    this.changeVisitHelperProvider = changeVisitHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert favoritesDoctorsHelperProvider != null;
    this.favoritesDoctorsHelperProvider = favoritesDoctorsHelperProvider;
    assert doctorLoaderHelperProvider != null;
    this.doctorLoaderHelperProvider = doctorLoaderHelperProvider;
  }

  @Override
  public CreateVisitPresenterImpl get() {
    return MembersInjectors.injectMembers(
        createVisitPresenterImplMembersInjector,
        new CreateVisitPresenterImpl(
            changeVisitHelperProvider.get(),
            preferencesUtilsProvider.get(),
            navigatorProvider.get(),
            dialogsHelperProvider.get(),
            patientHelperProvider.get(),
            favoritesDoctorsHelperProvider.get(),
            doctorLoaderHelperProvider.get()));
  }

  public static Factory<CreateVisitPresenterImpl> create(
      MembersInjector<CreateVisitPresenterImpl> createVisitPresenterImplMembersInjector,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<FavoritesDoctorsHelper> favoritesDoctorsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider) {
    return new CreateVisitPresenterImpl_Factory(
        createVisitPresenterImplMembersInjector,
        changeVisitHelperProvider,
        preferencesUtilsProvider,
        navigatorProvider,
        dialogsHelperProvider,
        patientHelperProvider,
        favoritesDoctorsHelperProvider,
        doctorLoaderHelperProvider);
  }
}
