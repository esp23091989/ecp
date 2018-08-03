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
public final class DiaryEditRecordsPresenterImpl_Factory
    implements Factory<DiaryEditRecordsPresenterImpl> {
  private final MembersInjector<DiaryEditRecordsPresenterImpl>
      diaryEditRecordsPresenterImplMembersInjector;

  private final Provider<ChangeDiaryHelper> changeDiaryHelperProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public DiaryEditRecordsPresenterImpl_Factory(
      MembersInjector<DiaryEditRecordsPresenterImpl> diaryEditRecordsPresenterImplMembersInjector,
      Provider<ChangeDiaryHelper> changeDiaryHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert diaryEditRecordsPresenterImplMembersInjector != null;
    this.diaryEditRecordsPresenterImplMembersInjector =
        diaryEditRecordsPresenterImplMembersInjector;
    assert changeDiaryHelperProvider != null;
    this.changeDiaryHelperProvider = changeDiaryHelperProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  @Override
  public DiaryEditRecordsPresenterImpl get() {
    return MembersInjectors.injectMembers(
        diaryEditRecordsPresenterImplMembersInjector,
        new DiaryEditRecordsPresenterImpl(
            changeDiaryHelperProvider.get(), dialogsHelperProvider.get()));
  }

  public static Factory<DiaryEditRecordsPresenterImpl> create(
      MembersInjector<DiaryEditRecordsPresenterImpl> diaryEditRecordsPresenterImplMembersInjector,
      Provider<ChangeDiaryHelper> changeDiaryHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new DiaryEditRecordsPresenterImpl_Factory(
        diaryEditRecordsPresenterImplMembersInjector,
        changeDiaryHelperProvider,
        dialogsHelperProvider);
  }
}
