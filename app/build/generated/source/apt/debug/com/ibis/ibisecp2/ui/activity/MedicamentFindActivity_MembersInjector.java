package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.MedicamentFindPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MedicamentFindActivity_MembersInjector
    implements MembersInjector<MedicamentFindActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<MedicamentFindPresenter> medicamentFindPresenterProvider;

  public MedicamentFindActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<MedicamentFindPresenter> medicamentFindPresenterProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert medicamentFindPresenterProvider != null;
    this.medicamentFindPresenterProvider = medicamentFindPresenterProvider;
  }

  public static MembersInjector<MedicamentFindActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<MedicamentFindPresenter> medicamentFindPresenterProvider) {
    return new MedicamentFindActivity_MembersInjector(
        navigatorProvider,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        medicamentFindPresenterProvider);
  }

  @Override
  public void injectMembers(MedicamentFindActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.medicamentFindPresenter = medicamentFindPresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectMedicamentFindPresenter(
      MedicamentFindActivity instance,
      Provider<MedicamentFindPresenter> medicamentFindPresenterProvider) {
    instance.medicamentFindPresenter = medicamentFindPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      MedicamentFindActivity instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectDialogsHelper(
      MedicamentFindActivity instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }
}
