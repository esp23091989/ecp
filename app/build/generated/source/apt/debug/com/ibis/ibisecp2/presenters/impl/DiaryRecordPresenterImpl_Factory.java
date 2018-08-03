package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DiaryRecordsLoaderHelper;
import com.ibis.ibisecp2.helpers.TasksHelper;
import com.ibis.ibisecp2.ui.Navigator;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DiaryRecordPresenterImpl_Factory implements Factory<DiaryRecordPresenterImpl> {
  private final MembersInjector<DiaryRecordPresenterImpl> diaryRecordPresenterImplMembersInjector;

  private final Provider<DiaryRecordsLoaderHelper> loaderHelperProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<TasksHelper> tasksHelperProvider;

  public DiaryRecordPresenterImpl_Factory(
      MembersInjector<DiaryRecordPresenterImpl> diaryRecordPresenterImplMembersInjector,
      Provider<DiaryRecordsLoaderHelper> loaderHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<TasksHelper> tasksHelperProvider) {
    assert diaryRecordPresenterImplMembersInjector != null;
    this.diaryRecordPresenterImplMembersInjector = diaryRecordPresenterImplMembersInjector;
    assert loaderHelperProvider != null;
    this.loaderHelperProvider = loaderHelperProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert tasksHelperProvider != null;
    this.tasksHelperProvider = tasksHelperProvider;
  }

  @Override
  public DiaryRecordPresenterImpl get() {
    return MembersInjectors.injectMembers(
        diaryRecordPresenterImplMembersInjector,
        new DiaryRecordPresenterImpl(
            loaderHelperProvider.get(),
            dialogsHelperProvider.get(),
            navigatorProvider.get(),
            tasksHelperProvider.get()));
  }

  public static Factory<DiaryRecordPresenterImpl> create(
      MembersInjector<DiaryRecordPresenterImpl> diaryRecordPresenterImplMembersInjector,
      Provider<DiaryRecordsLoaderHelper> loaderHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<TasksHelper> tasksHelperProvider) {
    return new DiaryRecordPresenterImpl_Factory(
        diaryRecordPresenterImplMembersInjector,
        loaderHelperProvider,
        dialogsHelperProvider,
        navigatorProvider,
        tasksHelperProvider);
  }
}
