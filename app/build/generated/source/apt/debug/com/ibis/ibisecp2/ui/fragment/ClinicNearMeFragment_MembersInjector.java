package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.ClinicNearMePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClinicNearMeFragment_MembersInjector
    implements MembersInjector<ClinicNearMeFragment> {
  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  private final Provider<ClinicNearMePresenter> mPresenterProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public ClinicNearMeFragment_MembersInjector(
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider,
      Provider<ClinicNearMePresenter> mPresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  public static MembersInjector<ClinicNearMeFragment> create(
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider,
      Provider<ClinicNearMePresenter> mPresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new ClinicNearMeFragment_MembersInjector(
        mShowHideLoadHelperProvider, mPresenterProvider, dialogsHelperProvider);
  }

  @Override
  public void injectMembers(ClinicNearMeFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
    instance.mPresenter = mPresenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      ClinicNearMeFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectMPresenter(
      ClinicNearMeFragment instance, Provider<ClinicNearMePresenter> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectDialogsHelper(
      ClinicNearMeFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }
}
