package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.PersonalPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalActivity_MembersInjector implements MembersInjector<PersonalActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<PersonalPresenter> mPersonalPresenterProvider;

  public PersonalActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PersonalPresenter> mPersonalPresenterProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert mPersonalPresenterProvider != null;
    this.mPersonalPresenterProvider = mPersonalPresenterProvider;
  }

  public static MembersInjector<PersonalActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<PersonalPresenter> mPersonalPresenterProvider) {
    return new PersonalActivity_MembersInjector(
        navigatorProvider,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        mPersonalPresenterProvider);
  }

  @Override
  public void injectMembers(PersonalActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.mPersonalPresenter = mPersonalPresenterProvider.get();
  }

  public static void injectMPersonalPresenter(
      PersonalActivity instance, Provider<PersonalPresenter> mPersonalPresenterProvider) {
    instance.mPersonalPresenter = mPersonalPresenterProvider.get();
  }
}
