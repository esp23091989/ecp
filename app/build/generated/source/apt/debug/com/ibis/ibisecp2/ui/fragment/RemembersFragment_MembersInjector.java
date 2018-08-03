package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.RemembersPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemembersFragment_MembersInjector implements MembersInjector<RemembersFragment> {
  private final Provider<RemembersPresenter> remembersPresenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public RemembersFragment_MembersInjector(
      Provider<RemembersPresenter> remembersPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert remembersPresenterProvider != null;
    this.remembersPresenterProvider = remembersPresenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<RemembersFragment> create(
      Provider<RemembersPresenter> remembersPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new RemembersFragment_MembersInjector(
        remembersPresenterProvider,
        preferencesUtilsProvider,
        navigatorProvider,
        mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(RemembersFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.remembersPresenter = remembersPresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.navigator = navigatorProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectRemembersPresenter(
      RemembersFragment instance, Provider<RemembersPresenter> remembersPresenterProvider) {
    instance.remembersPresenter = remembersPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      RemembersFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectNavigator(
      RemembersFragment instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      RemembersFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
