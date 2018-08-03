package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ScheduleLoaderHelper;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataChoosePresenterImpl_Factory implements Factory<DataChoosePresenterImpl> {
  private final MembersInjector<DataChoosePresenterImpl> dataChoosePresenterImplMembersInjector;

  private final Provider<ScheduleLoaderHelper> loadScheduleProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public DataChoosePresenterImpl_Factory(
      MembersInjector<DataChoosePresenterImpl> dataChoosePresenterImplMembersInjector,
      Provider<ScheduleLoaderHelper> loadScheduleProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert dataChoosePresenterImplMembersInjector != null;
    this.dataChoosePresenterImplMembersInjector = dataChoosePresenterImplMembersInjector;
    assert loadScheduleProvider != null;
    this.loadScheduleProvider = loadScheduleProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public DataChoosePresenterImpl get() {
    return MembersInjectors.injectMembers(
        dataChoosePresenterImplMembersInjector,
        new DataChoosePresenterImpl(
            loadScheduleProvider.get(),
            dialogsHelperProvider.get(),
            navigatorProvider.get(),
            preferencesUtilsProvider.get()));
  }

  public static Factory<DataChoosePresenterImpl> create(
      MembersInjector<DataChoosePresenterImpl> dataChoosePresenterImplMembersInjector,
      Provider<ScheduleLoaderHelper> loadScheduleProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new DataChoosePresenterImpl_Factory(
        dataChoosePresenterImplMembersInjector,
        loadScheduleProvider,
        dialogsHelperProvider,
        navigatorProvider,
        preferencesUtilsProvider);
  }
}
