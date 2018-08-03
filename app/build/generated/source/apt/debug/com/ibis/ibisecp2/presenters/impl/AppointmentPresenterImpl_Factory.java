package com.ibis.ibisecp2.presenters.impl;

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
public final class AppointmentPresenterImpl_Factory implements Factory<AppointmentPresenterImpl> {
  private final MembersInjector<AppointmentPresenterImpl> appointmentPresenterImplMembersInjector;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public AppointmentPresenterImpl_Factory(
      MembersInjector<AppointmentPresenterImpl> appointmentPresenterImplMembersInjector,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert appointmentPresenterImplMembersInjector != null;
    this.appointmentPresenterImplMembersInjector = appointmentPresenterImplMembersInjector;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public AppointmentPresenterImpl get() {
    return MembersInjectors.injectMembers(
        appointmentPresenterImplMembersInjector,
        new AppointmentPresenterImpl(navigatorProvider.get(), preferencesUtilsProvider.get()));
  }

  public static Factory<AppointmentPresenterImpl> create(
      MembersInjector<AppointmentPresenterImpl> appointmentPresenterImplMembersInjector,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new AppointmentPresenterImpl_Factory(
        appointmentPresenterImplMembersInjector, navigatorProvider, preferencesUtilsProvider);
  }
}
