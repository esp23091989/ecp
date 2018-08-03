package com.ibis.ibisecp2.ui.activity;

import com.ibis.ibisecp2.helpers.DialogsHelper;
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
public final class DiaryNewRecordsActivity_MembersInjector
    implements MembersInjector<DiaryNewRecordsActivity> {
  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DiaryEditRecordsPresenter> diaryEditRecordsPresenterProvider;

  public DiaryNewRecordsActivity_MembersInjector(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DiaryEditRecordsPresenter> diaryEditRecordsPresenterProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert diaryEditRecordsPresenterProvider != null;
    this.diaryEditRecordsPresenterProvider = diaryEditRecordsPresenterProvider;
  }

  public static MembersInjector<DiaryNewRecordsActivity> create(
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DiaryEditRecordsPresenter> diaryEditRecordsPresenterProvider) {
    return new DiaryNewRecordsActivity_MembersInjector(
        navigatorProvider,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        diaryEditRecordsPresenterProvider);
  }

  @Override
  public void injectMembers(DiaryNewRecordsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).navigator = navigatorProvider.get();
    ((BaseActivity) instance).dialogsHelper = dialogsHelperProvider.get();
    ((BaseActivity) instance).preferencesUtils = preferencesUtilsProvider.get();
    instance.diaryEditRecordsPresenter = diaryEditRecordsPresenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectDiaryEditRecordsPresenter(
      DiaryNewRecordsActivity instance,
      Provider<DiaryEditRecordsPresenter> diaryEditRecordsPresenterProvider) {
    instance.diaryEditRecordsPresenter = diaryEditRecordsPresenterProvider.get();
  }

  public static void injectDialogsHelper(
      DiaryNewRecordsActivity instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }
}
