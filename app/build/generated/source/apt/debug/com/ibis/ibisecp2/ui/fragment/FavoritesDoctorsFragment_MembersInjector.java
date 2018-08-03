package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.FavoritesDoctorsPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FavoritesDoctorsFragment_MembersInjector
    implements MembersInjector<FavoritesDoctorsFragment> {
  private final Provider<FavoritesDoctorsPresenter> mPresenterProvider;

  private final Provider<ShowHideLoadHelper> mHelperAndMShowHideLoadHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public FavoritesDoctorsFragment_MembersInjector(
      Provider<FavoritesDoctorsPresenter> mPresenterProvider,
      Provider<ShowHideLoadHelper> mHelperAndMShowHideLoadHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
    assert mHelperAndMShowHideLoadHelperProvider != null;
    this.mHelperAndMShowHideLoadHelperProvider = mHelperAndMShowHideLoadHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  public static MembersInjector<FavoritesDoctorsFragment> create(
      Provider<FavoritesDoctorsPresenter> mPresenterProvider,
      Provider<ShowHideLoadHelper> mHelperAndMShowHideLoadHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new FavoritesDoctorsFragment_MembersInjector(
        mPresenterProvider,
        mHelperAndMShowHideLoadHelperProvider,
        navigatorProvider,
        preferencesUtilsProvider,
        dialogsHelperProvider);
  }

  @Override
  public void injectMembers(FavoritesDoctorsFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
    instance.mHelper = mHelperAndMShowHideLoadHelperProvider.get();
    instance.navigator = navigatorProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.mShowHideLoadHelper = mHelperAndMShowHideLoadHelperProvider.get();
  }

  public static void injectMPresenter(
      FavoritesDoctorsFragment instance, Provider<FavoritesDoctorsPresenter> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMHelper(
      FavoritesDoctorsFragment instance, Provider<ShowHideLoadHelper> mHelperProvider) {
    instance.mHelper = mHelperProvider.get();
  }

  public static void injectNavigator(
      FavoritesDoctorsFragment instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }

  public static void injectPreferencesUtils(
      FavoritesDoctorsFragment instance,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectDialogsHelper(
      FavoritesDoctorsFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      FavoritesDoctorsFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
