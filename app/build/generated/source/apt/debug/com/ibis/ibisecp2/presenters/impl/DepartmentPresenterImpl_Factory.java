package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.ui.Navigator;
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
public final class DepartmentPresenterImpl_Factory implements Factory<DepartmentPresenterImpl> {
  private final MembersInjector<DepartmentPresenterImpl> departmentPresenterImplMembersInjector;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<DoctorLoaderHelper> doctorLoaderHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  public DepartmentPresenterImpl_Factory(
      MembersInjector<DepartmentPresenterImpl> departmentPresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<PatientHelper> patientHelperProvider) {
    assert departmentPresenterImplMembersInjector != null;
    this.departmentPresenterImplMembersInjector = departmentPresenterImplMembersInjector;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert doctorLoaderHelperProvider != null;
    this.doctorLoaderHelperProvider = doctorLoaderHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
  }

  @Override
  public DepartmentPresenterImpl get() {
    return MembersInjectors.injectMembers(
        departmentPresenterImplMembersInjector,
        new DepartmentPresenterImpl(
            dialogsHelperProvider.get(),
            doctorLoaderHelperProvider.get(),
            navigatorProvider.get(),
            preferencesUtilsProvider.get(),
            rxUtilProvider.get(),
            patientHelperProvider.get()));
  }

  public static Factory<DepartmentPresenterImpl> create(
      MembersInjector<DepartmentPresenterImpl> departmentPresenterImplMembersInjector,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<DoctorLoaderHelper> doctorLoaderHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<PatientHelper> patientHelperProvider) {
    return new DepartmentPresenterImpl_Factory(
        departmentPresenterImplMembersInjector,
        dialogsHelperProvider,
        doctorLoaderHelperProvider,
        navigatorProvider,
        preferencesUtilsProvider,
        rxUtilProvider,
        patientHelperProvider);
  }
}
