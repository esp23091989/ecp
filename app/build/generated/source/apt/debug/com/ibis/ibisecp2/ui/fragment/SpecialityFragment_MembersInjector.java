package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.SpecialityPresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SpecialityFragment_MembersInjector
    implements MembersInjector<SpecialityFragment> {
  private final Provider<SpecialityPresenter> presenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public SpecialityFragment_MembersInjector(
      Provider<SpecialityPresenter> presenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<SpecialityFragment> create(
      Provider<SpecialityPresenter> presenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new SpecialityFragment_MembersInjector(
        presenterProvider, preferencesUtilsProvider, mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(SpecialityFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectPresenter(
      SpecialityFragment instance, Provider<SpecialityPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectPreferencesUtils(
      SpecialityFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      SpecialityFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
