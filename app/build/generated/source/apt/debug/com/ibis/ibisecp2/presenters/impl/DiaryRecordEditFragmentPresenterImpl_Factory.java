package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ChangeDiaryHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DiaryRecordEditFragmentPresenterImpl_Factory
    implements Factory<DiaryRecordEditFragmentPresenterImpl> {
  private final MembersInjector<DiaryRecordEditFragmentPresenterImpl>
      diaryRecordEditFragmentPresenterImplMembersInjector;

  private final Provider<ChangeDiaryHelper> changeDiaryHelperProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public DiaryRecordEditFragmentPresenterImpl_Factory(
      MembersInjector<DiaryRecordEditFragmentPresenterImpl>
          diaryRecordEditFragmentPresenterImplMembersInjector,
      Provider<ChangeDiaryHelper> changeDiaryHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert diaryRecordEditFragmentPresenterImplMembersInjector != null;
    this.diaryRecordEditFragmentPresenterImplMembersInjector =
        diaryRecordEditFragmentPresenterImplMembersInjector;
    assert changeDiaryHelperProvider != null;
    this.changeDiaryHelperProvider = changeDiaryHelperProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  @Override
  public DiaryRecordEditFragmentPresenterImpl get() {
    return MembersInjectors.injectMembers(
        diaryRecordEditFragmentPresenterImplMembersInjector,
        new DiaryRecordEditFragmentPresenterImpl(
            changeDiaryHelperProvider.get(), dialogsHelperProvider.get()));
  }

  public static Factory<DiaryRecordEditFragmentPresenterImpl> create(
      MembersInjector<DiaryRecordEditFragmentPresenterImpl>
          diaryRecordEditFragmentPresenterImplMembersInjector,
      Provider<ChangeDiaryHelper> changeDiaryHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new DiaryRecordEditFragmentPresenterImpl_Factory(
        diaryRecordEditFragmentPresenterImplMembersInjector,
        changeDiaryHelperProvider,
        dialogsHelperProvider);
  }
}
