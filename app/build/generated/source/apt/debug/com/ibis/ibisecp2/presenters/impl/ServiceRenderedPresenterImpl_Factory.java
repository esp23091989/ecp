package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ServiceRenderedLoaderHelper;
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
public final class ServiceRenderedPresenterImpl_Factory
    implements Factory<ServiceRenderedPresenterImpl> {
  private final MembersInjector<ServiceRenderedPresenterImpl>
      serviceRenderedPresenterImplMembersInjector;

  private final Provider<ServiceRenderedLoaderHelper> loaderHelperProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public ServiceRenderedPresenterImpl_Factory(
      MembersInjector<ServiceRenderedPresenterImpl> serviceRenderedPresenterImplMembersInjector,
      Provider<ServiceRenderedLoaderHelper> loaderHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert serviceRenderedPresenterImplMembersInjector != null;
    this.serviceRenderedPresenterImplMembersInjector = serviceRenderedPresenterImplMembersInjector;
    assert loaderHelperProvider != null;
    this.loaderHelperProvider = loaderHelperProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  @Override
  public ServiceRenderedPresenterImpl get() {
    return MembersInjectors.injectMembers(
        serviceRenderedPresenterImplMembersInjector,
        new ServiceRenderedPresenterImpl(
            loaderHelperProvider.get(),
            preferencesUtilsProvider.get(),
            dialogsHelperProvider.get()));
  }

  public static Factory<ServiceRenderedPresenterImpl> create(
      MembersInjector<ServiceRenderedPresenterImpl> serviceRenderedPresenterImplMembersInjector,
      Provider<ServiceRenderedLoaderHelper> loaderHelperProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new ServiceRenderedPresenterImpl_Factory(
        serviceRenderedPresenterImplMembersInjector,
        loaderHelperProvider,
        preferencesUtilsProvider,
        dialogsHelperProvider);
  }
}
