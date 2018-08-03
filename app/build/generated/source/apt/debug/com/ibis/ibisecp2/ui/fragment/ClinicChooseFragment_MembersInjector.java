package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.ClinicChoosePresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClinicChooseFragment_MembersInjector
    implements MembersInjector<ClinicChooseFragment> {
  private final Provider<ClinicChoosePresenter> clinicChoosePresenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public ClinicChooseFragment_MembersInjector(
      Provider<ClinicChoosePresenter> clinicChoosePresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert clinicChoosePresenterProvider != null;
    this.clinicChoosePresenterProvider = clinicChoosePresenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<ClinicChooseFragment> create(
      Provider<ClinicChoosePresenter> clinicChoosePresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new ClinicChooseFragment_MembersInjector(
        clinicChoosePresenterProvider,
        preferencesUtilsProvider,
        dialogsHelperProvider,
        mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(ClinicChooseFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.clinicChoosePresenter = clinicChoosePresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectClinicChoosePresenter(
      ClinicChooseFragment instance,
      Provider<ClinicChoosePresenter> clinicChoosePresenterProvider) {
    instance.clinicChoosePresenter = clinicChoosePresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      ClinicChooseFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectDialogsHelper(
      ClinicChooseFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      ClinicChooseFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
