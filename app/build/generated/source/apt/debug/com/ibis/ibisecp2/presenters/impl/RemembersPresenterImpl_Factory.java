package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.storage.Storage;
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
public final class RemembersPresenterImpl_Factory implements Factory<RemembersPresenterImpl> {
  private final MembersInjector<RemembersPresenterImpl> remembersPresenterImplMembersInjector;

  private final Provider<ChangeVisitHelper> changeVisitHelperProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<Storage> storageProvider;

  public RemembersPresenterImpl_Factory(
      MembersInjector<RemembersPresenterImpl> remembersPresenterImplMembersInjector,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<Storage> storageProvider) {
    assert remembersPresenterImplMembersInjector != null;
    this.remembersPresenterImplMembersInjector = remembersPresenterImplMembersInjector;
    assert changeVisitHelperProvider != null;
    this.changeVisitHelperProvider = changeVisitHelperProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert storageProvider != null;
    this.storageProvider = storageProvider;
  }

  @Override
  public RemembersPresenterImpl get() {
    return MembersInjectors.injectMembers(
        remembersPresenterImplMembersInjector,
        new RemembersPresenterImpl(
            changeVisitHelperProvider.get(),
            dialogsHelperProvider.get(),
            preferencesUtilsProvider.get(),
            navigatorProvider.get(),
            storageProvider.get()));
  }

  public static Factory<RemembersPresenterImpl> create(
      MembersInjector<RemembersPresenterImpl> remembersPresenterImplMembersInjector,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<Navigator> navigatorProvider,
      Provider<Storage> storageProvider) {
    return new RemembersPresenterImpl_Factory(
        remembersPresenterImplMembersInjector,
        changeVisitHelperProvider,
        dialogsHelperProvider,
        preferencesUtilsProvider,
        navigatorProvider,
        storageProvider);
  }
}
