package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.CreateVisitPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class EnrollFragment_MembersInjector implements MembersInjector<EnrollFragment> {
  private final Provider<CreateVisitPresenter> createVisitPresenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public EnrollFragment_MembersInjector(
      Provider<CreateVisitPresenter> createVisitPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert createVisitPresenterProvider != null;
    this.createVisitPresenterProvider = createVisitPresenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<EnrollFragment> create(
      Provider<CreateVisitPresenter> createVisitPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new EnrollFragment_MembersInjector(
        createVisitPresenterProvider,
        preferencesUtilsProvider,
        navigatorProvider,
        dialogsHelperProvider,
        mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(EnrollFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.createVisitPresenter = createVisitPresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.navigator = navigatorProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectCreateVisitPresenter(
      EnrollFragment instance, Provider<CreateVisitPresenter> createVisitPresenterProvider) {
    instance.createVisitPresenter = createVisitPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      EnrollFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectNavigator(
      EnrollFragment instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }

  public static void injectDialogsHelper(
      EnrollFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      EnrollFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
