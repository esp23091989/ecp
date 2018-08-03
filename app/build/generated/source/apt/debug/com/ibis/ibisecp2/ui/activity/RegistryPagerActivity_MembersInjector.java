package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.RegistryPagerPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RegistryPagerActivity_MembersInjector
    implements MembersInjector<RegistryPagerActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<RegistryPagerPresenter> mRegistryPagerPresenterProvider;

  public RegistryPagerActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<RegistryPagerPresenter> mRegistryPagerPresenterProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert mRegistryPagerPresenterProvider != null;
    this.mRegistryPagerPresenterProvider = mRegistryPagerPresenterProvider;
  }

  public static MembersInjector<RegistryPagerActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<RegistryPagerPresenter> mRegistryPagerPresenterProvider) {
    return new RegistryPagerActivity_MembersInjector(
        navigatorProvider,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        mRegistryPagerPresenterProvider);
  }

  @Override
  public void injectMembers(RegistryPagerActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.mRegistryPagerPresenter = mRegistryPagerPresenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectMRegistryPagerPresenter(
      RegistryPagerActivity instance,
      Provider<RegistryPagerPresenter> mRegistryPagerPresenterProvider) {
    instance.mRegistryPagerPresenter = mRegistryPagerPresenterProvider.get();
  }

  public static void injectDialogsHelper(
      RegistryPagerActivity instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }
}
