package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.DataChoosePresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScheduleFragment_MembersInjector implements MembersInjector<ScheduleFragment> {
  private final Provider<DataChoosePresenter> dataChoosePresenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public ScheduleFragment_MembersInjector(
      Provider<DataChoosePresenter> dataChoosePresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert dataChoosePresenterProvider != null;
    this.dataChoosePresenterProvider = dataChoosePresenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<ScheduleFragment> create(
      Provider<DataChoosePresenter> dataChoosePresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new ScheduleFragment_MembersInjector(
        dataChoosePresenterProvider, preferencesUtilsProvider, mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(ScheduleFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.dataChoosePresenter = dataChoosePresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectDataChoosePresenter(
      ScheduleFragment instance, Provider<DataChoosePresenter> dataChoosePresenterProvider) {
    instance.dataChoosePresenter = dataChoosePresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      ScheduleFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      ScheduleFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
