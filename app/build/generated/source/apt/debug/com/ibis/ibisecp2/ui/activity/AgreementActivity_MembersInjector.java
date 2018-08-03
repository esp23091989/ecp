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
public final class AgreementActivity_MembersInjector implements MembersInjector<AgreementActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public AgreementActivity_MembersInjector(
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

  public static MembersInjector<AgreementActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new AgreementActivity_MembersInjector(
        navigatorProvider, dialogsHelperProvider, preferencesUtilsProvider);
  }

  @Override
  public void injectMembers(AgreementActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
  }
}
