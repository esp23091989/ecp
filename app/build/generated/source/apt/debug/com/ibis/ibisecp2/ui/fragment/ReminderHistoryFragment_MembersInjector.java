package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.HistoryPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReminderHistoryFragment_MembersInjector
    implements MembersInjector<ReminderHistoryFragment> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<HistoryPresenter> historyPresenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public ReminderHistoryFragment_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<HistoryPresenter> historyPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert historyPresenterProvider != null;
    this.historyPresenterProvider = historyPresenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<ReminderHistoryFragment> create(
      Provider<Navigator> navigatorProvider,
      Provider<HistoryPresenter> historyPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new ReminderHistoryFragment_MembersInjector(
        navigatorProvider,
        historyPresenterProvider,
        preferencesUtilsProvider,
        mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(ReminderHistoryFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.navigator = navigatorProvider.get();
    instance.historyPresenter = historyPresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectNavigator(
      ReminderHistoryFragment instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }

  public static void injectHistoryPresenter(
      ReminderHistoryFragment instance, Provider<HistoryPresenter> historyPresenterProvider) {
    instance.historyPresenter = historyPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      ReminderHistoryFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      ReminderHistoryFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
