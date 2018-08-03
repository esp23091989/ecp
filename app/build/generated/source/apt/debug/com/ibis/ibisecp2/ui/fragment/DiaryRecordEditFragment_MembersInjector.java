package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.DiaryRecordEditFragmentPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DiaryRecordEditFragment_MembersInjector
    implements MembersInjector<DiaryRecordEditFragment> {
  private final Provider<DiaryRecordEditFragmentPresenter> mPresenterProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public DiaryRecordEditFragment_MembersInjector(
      Provider<DiaryRecordEditFragmentPresenter> mPresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<DiaryRecordEditFragment> create(
      Provider<DiaryRecordEditFragmentPresenter> mPresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new DiaryRecordEditFragment_MembersInjector(
        mPresenterProvider, dialogsHelperProvider, mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(DiaryRecordEditFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectMPresenter(
      DiaryRecordEditFragment instance,
      Provider<DiaryRecordEditFragmentPresenter> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectDialogsHelper(
      DiaryRecordEditFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      DiaryRecordEditFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
