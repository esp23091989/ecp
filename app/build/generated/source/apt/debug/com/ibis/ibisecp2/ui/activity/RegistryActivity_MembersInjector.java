package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RegistryActivity_MembersInjector implements MembersInjector<RegistryActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public RegistryActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  public static MembersInjector<RegistryActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new RegistryActivity_MembersInjector(
        navigatorProvider, dialogsHelperProvider, preferencesUtilsProvider);
  }

  @Override
  public void injectMembers(RegistryActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectDialogsHelper(
      RegistryActivity instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectPreferencesUtils(
      RegistryActivity instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }
}
