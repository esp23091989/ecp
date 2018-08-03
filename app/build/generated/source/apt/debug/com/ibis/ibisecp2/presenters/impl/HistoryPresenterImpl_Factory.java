package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.storage.Storage;
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
public final class HistoryPresenterImpl_Factory implements Factory<HistoryPresenterImpl> {
  private final MembersInjector<HistoryPresenterImpl> historyPresenterImplMembersInjector;

  private final Provider<ChangeVisitHelper> changeVisitHelperProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<Storage> storageProvider;

  private final Provider<Navigator> navigatorProvider;

  public HistoryPresenterImpl_Factory(
      MembersInjector<HistoryPresenterImpl> historyPresenterImplMembersInjector,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Storage> storageProvider,
      Provider<Navigator> navigatorProvider) {
    assert historyPresenterImplMembersInjector != null;
    this.historyPresenterImplMembersInjector = historyPresenterImplMembersInjector;
    assert changeVisitHelperProvider != null;
    this.changeVisitHelperProvider = changeVisitHelperProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert storageProvider != null;
    this.storageProvider = storageProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public HistoryPresenterImpl get() {
    return MembersInjectors.injectMembers(
        historyPresenterImplMembersInjector,
        new HistoryPresenterImpl(
            changeVisitHelperProvider.get(),
            dialogsHelperProvider.get(),
            storageProvider.get(),
            navigatorProvider.get()));
  }

  public static Factory<HistoryPresenterImpl> create(
      MembersInjector<HistoryPresenterImpl> historyPresenterImplMembersInjector,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<Storage> storageProvider,
      Provider<Navigator> navigatorProvider) {
    return new HistoryPresenterImpl_Factory(
        historyPresenterImplMembersInjector,
        changeVisitHelperProvider,
        dialogsHelperProvider,
        storageProvider,
        navigatorProvider);
  }
}
