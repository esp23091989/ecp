package com.ibis.ibisecp2.ui.activity;

import android.content.res.Resources;
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
public final class SetupNotificationActivity_MembersInjector
    implements MembersInjector<SetupNotificationActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<Resources> resourcesProvider;

  public SetupNotificationActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Resources> resourcesProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert resourcesProvider != null;
    this.resourcesProvider = resourcesProvider;
  }

  public static MembersInjector<SetupNotificationActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Resources> resourcesProvider) {
    return new SetupNotificationActivity_MembersInjector(
        navigatorProvider, dialogsHelperProvider, preferencesUtilsProvider, resourcesProvider);
  }

  @Override
  public void injectMembers(SetupNotificationActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.resources = resourcesProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectResources(
      SetupNotificationActivity instance, Provider<Resources> resourcesProvider) {
    instance.resources = resourcesProvider.get();
  }

  public static void injectPreferencesUtils(
      SetupNotificationActivity instance,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }
}
