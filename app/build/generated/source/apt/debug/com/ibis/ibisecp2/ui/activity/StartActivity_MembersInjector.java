package com.ibis.ibisecp2.ui.activity;

import android.content.res.Resources;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.StartPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StartActivity_MembersInjector implements MembersInjector<StartActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> mPreferencesUtilsAndPreferencesUtilsProvider;

  private final Provider<StartPresenter> startPresenterProvider;

  private final Provider<Resources> resourcesProvider;

  public StartActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> mPreferencesUtilsAndPreferencesUtilsProvider,
      Provider<StartPresenter> startPresenterProvider,
      Provider<Resources> resourcesProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert mPreferencesUtilsAndPreferencesUtilsProvider != null;
    this.mPreferencesUtilsAndPreferencesUtilsProvider =
        mPreferencesUtilsAndPreferencesUtilsProvider;
    assert startPresenterProvider != null;
    this.startPresenterProvider = startPresenterProvider;
    assert resourcesProvider != null;
    this.resourcesProvider = resourcesProvider;
  }

  public static MembersInjector<StartActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> mPreferencesUtilsAndPreferencesUtilsProvider,
      Provider<StartPresenter> startPresenterProvider,
      Provider<Resources> resourcesProvider) {
    return new StartActivity_MembersInjector(
        navigatorProvider,
        dialogsHelperProvider,
        mPreferencesUtilsAndPreferencesUtilsProvider,
        startPresenterProvider,
        resourcesProvider);
  }

  @Override
  public void injectMembers(StartActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = mPreferencesUtilsAndPreferencesUtilsProvider.get();
    instance.startPresenter = startPresenterProvider.get();
    instance.preferencesUtils = mPreferencesUtilsAndPreferencesUtilsProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.navigator = navigatorProvider.get();
    instance.resources = resourcesProvider.get();
    instance.mPreferencesUtils = mPreferencesUtilsAndPreferencesUtilsProvider.get();
  }

  public static void injectStartPresenter(
      StartActivity instance, Provider<StartPresenter> startPresenterProvider) {
    instance.startPresenter = startPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      StartActivity instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectDialogsHelper(
      StartActivity instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectNavigator(
      StartActivity instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }

  public static void injectResources(
      StartActivity instance, Provider<Resources> resourcesProvider) {
    instance.resources = resourcesProvider.get();
  }

  public static void injectMPreferencesUtils(
      StartActivity instance, Provider<SharedPreferencesUtils> mPreferencesUtilsProvider) {
    instance.mPreferencesUtils = mPreferencesUtilsProvider.get();
  }
}
