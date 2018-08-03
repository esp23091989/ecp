package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.AppointmentPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppointmentActivity_MembersInjector
    implements MembersInjector<AppointmentActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<AppointmentPresenter> appointmentPresenterProvider;

  public AppointmentActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<AppointmentPresenter> appointmentPresenterProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert appointmentPresenterProvider != null;
    this.appointmentPresenterProvider = appointmentPresenterProvider;
  }

  public static MembersInjector<AppointmentActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<AppointmentPresenter> appointmentPresenterProvider) {
    return new AppointmentActivity_MembersInjector(
        navigatorProvider,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        appointmentPresenterProvider);
  }

  @Override
  public void injectMembers(AppointmentActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.appointmentPresenter = appointmentPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      AppointmentActivity instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectAppointmentPresenter(
      AppointmentActivity instance, Provider<AppointmentPresenter> appointmentPresenterProvider) {
    instance.appointmentPresenter = appointmentPresenterProvider.get();
  }
}
