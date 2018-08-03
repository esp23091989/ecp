package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.DoctorsPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DoctorsFragment_MembersInjector implements MembersInjector<DoctorsFragment> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DoctorsPresenter> presenterProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public DoctorsFragment_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DoctorsPresenter> presenterProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<DoctorsFragment> create(
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DoctorsPresenter> presenterProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new DoctorsFragment_MembersInjector(
        navigatorProvider,
        preferencesUtilsProvider,
        presenterProvider,
        mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(DoctorsFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.navigator = navigatorProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.presenter = presenterProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectNavigator(
      DoctorsFragment instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }

  public static void injectPreferencesUtils(
      DoctorsFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectPresenter(
      DoctorsFragment instance, Provider<DoctorsPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      DoctorsFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
