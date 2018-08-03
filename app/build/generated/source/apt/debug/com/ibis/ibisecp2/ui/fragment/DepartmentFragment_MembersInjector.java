package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.DepartmentPresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DepartmentFragment_MembersInjector
    implements MembersInjector<DepartmentFragment> {
  private final Provider<DepartmentPresenter> presenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DialogsHelper> mDialogsHelperProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public DepartmentFragment_MembersInjector(
      Provider<DepartmentPresenter> presenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> mDialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert mDialogsHelperProvider != null;
    this.mDialogsHelperProvider = mDialogsHelperProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<DepartmentFragment> create(
      Provider<DepartmentPresenter> presenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> mDialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new DepartmentFragment_MembersInjector(
        presenterProvider,
        preferencesUtilsProvider,
        mDialogsHelperProvider,
        mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(DepartmentFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.mDialogsHelper = mDialogsHelperProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectPresenter(
      DepartmentFragment instance, Provider<DepartmentPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectPreferencesUtils(
      DepartmentFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectMDialogsHelper(
      DepartmentFragment instance, Provider<DialogsHelper> mDialogsHelperProvider) {
    instance.mDialogsHelper = mDialogsHelperProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      DepartmentFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
