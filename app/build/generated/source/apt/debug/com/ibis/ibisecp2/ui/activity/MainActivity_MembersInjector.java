package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.MainPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<MainPresenter> mMainPresenterProvider;

  public MainActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<MainPresenter> mMainPresenterProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert mMainPresenterProvider != null;
    this.mMainPresenterProvider = mMainPresenterProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<MainPresenter> mMainPresenterProvider) {
    return new MainActivity_MembersInjector(
        navigatorProvider, dialogsHelperProvider, preferencesUtilsProvider, mMainPresenterProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.mMainPresenter = mMainPresenterProvider.get();
  }

  public static void injectMMainPresenter(
      MainActivity instance, Provider<MainPresenter> mMainPresenterProvider) {
    instance.mMainPresenter = mMainPresenterProvider.get();
  }
}
