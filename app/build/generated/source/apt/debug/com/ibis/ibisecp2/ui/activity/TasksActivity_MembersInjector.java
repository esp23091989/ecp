package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.presenters.DiaryEditRecordsPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TasksActivity_MembersInjector implements MembersInjector<TasksActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DiaryEditRecordsPresenter> presenterProvider;

  private final Provider<ProgressDialogHelper> progressDialogHelperProvider;

  public TasksActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DiaryEditRecordsPresenter> presenterProvider,
      Provider<ProgressDialogHelper> progressDialogHelperProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert progressDialogHelperProvider != null;
    this.progressDialogHelperProvider = progressDialogHelperProvider;
  }

  public static MembersInjector<TasksActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DiaryEditRecordsPresenter> presenterProvider,
      Provider<ProgressDialogHelper> progressDialogHelperProvider) {
    return new TasksActivity_MembersInjector(
        navigatorProvider,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        presenterProvider,
        progressDialogHelperProvider);
  }

  @Override
  public void injectMembers(TasksActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.presenter = presenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.progressDialogHelper = progressDialogHelperProvider.get();
  }

  public static void injectPresenter(
      TasksActivity instance, Provider<DiaryEditRecordsPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectDialogsHelper(
      TasksActivity instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectProgressDialogHelper(
      TasksActivity instance, Provider<ProgressDialogHelper> progressDialogHelperProvider) {
    instance.progressDialogHelper = progressDialogHelperProvider.get();
  }
}
