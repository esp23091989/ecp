package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.RxUtil;
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
public final class VisitPresenterImpl_Factory implements Factory<VisitPresenterImpl> {
  private final MembersInjector<VisitPresenterImpl> visitPresenterImplMembersInjector;

  private final Provider<Storage> storageProvider;

  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<ChangeVisitHelper> changeVisitHelperProvider;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  private final Provider<PatientHelper> patientHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public VisitPresenterImpl_Factory(
      MembersInjector<VisitPresenterImpl> visitPresenterImplMembersInjector,
      Provider<Storage> storageProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert visitPresenterImplMembersInjector != null;
    this.visitPresenterImplMembersInjector = visitPresenterImplMembersInjector;
    assert storageProvider != null;
    this.storageProvider = storageProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert changeVisitHelperProvider != null;
    this.changeVisitHelperProvider = changeVisitHelperProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
    assert patientHelperProvider != null;
    this.patientHelperProvider = patientHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  @Override
  public VisitPresenterImpl get() {
    return MembersInjectors.injectMembers(
        visitPresenterImplMembersInjector,
        new VisitPresenterImpl(
            storageProvider.get(),
            rxUtilProvider.get(),
            changeVisitHelperProvider.get(),
            navigatorProvider.get(),
            dialogsHelperProvider.get(),
            patientHelperProvider.get(),
            preferencesUtilsProvider.get()));
  }

  public static Factory<VisitPresenterImpl> create(
      MembersInjector<VisitPresenterImpl> visitPresenterImplMembersInjector,
      Provider<Storage> storageProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<ChangeVisitHelper> changeVisitHelperProvider,
      Provider<Navigator> navigatorProvider,
      Provider<DialogsHelper> dialogsHelperProvider,
      Provider<PatientHelper> patientHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new VisitPresenterImpl_Factory(
        visitPresenterImplMembersInjector,
        storageProvider,
        rxUtilProvider,
        changeVisitHelperProvider,
        navigatorProvider,
        dialogsHelperProvider,
        patientHelperProvider,
        preferencesUtilsProvider);
  }
}
