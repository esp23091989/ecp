package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.DiaryRecordPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DiaryRecordsFragment_MembersInjector
    implements MembersInjector<DiaryRecordsFragment> {
  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DiaryRecordPresenter> diaryRecordPresenterProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public DiaryRecordsFragment_MembersInjector(
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DiaryRecordPresenter> diaryRecordPresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert diaryRecordPresenterProvider != null;
    this.diaryRecordPresenterProvider = diaryRecordPresenterProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<DiaryRecordsFragment> create(
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DiaryRecordPresenter> diaryRecordPresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new DiaryRecordsFragment_MembersInjector(
        preferencesUtilsProvider,
        diaryRecordPresenterProvider,
        dialogsHelperProvider,
        navigatorProvider,
        mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(DiaryRecordsFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.preferencesUtils = preferencesUtilsProvider.get();
    instance.diaryRecordPresenter = diaryRecordPresenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.navigator = navigatorProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectPreferencesUtils(
      DiaryRecordsFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectDiaryRecordPresenter(
      DiaryRecordsFragment instance, Provider<DiaryRecordPresenter> diaryRecordPresenterProvider) {
    instance.diaryRecordPresenter = diaryRecordPresenterProvider.get();
  }

  public static void injectDialogsHelper(
      DiaryRecordsFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectNavigator(
      DiaryRecordsFragment instance, Provider<Navigator> navigatorProvider) {
    instance.navigator = navigatorProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      DiaryRecordsFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
