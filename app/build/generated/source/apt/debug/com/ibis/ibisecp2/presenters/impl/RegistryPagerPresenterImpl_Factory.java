package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RegistryPagerPresenterImpl_Factory
    implements Factory<RegistryPagerPresenterImpl> {
  private final MembersInjector<RegistryPagerPresenterImpl>
      registryPagerPresenterImplMembersInjector;

  private final Provider<Storage> storageProvider;

  private final Provider<RxUtil> rxUtilProvider;

  public RegistryPagerPresenterImpl_Factory(
      MembersInjector<RegistryPagerPresenterImpl> registryPagerPresenterImplMembersInjector,
      Provider<Storage> storageProvider,
      Provider<RxUtil> rxUtilProvider) {
    assert registryPagerPresenterImplMembersInjector != null;
    this.registryPagerPresenterImplMembersInjector = registryPagerPresenterImplMembersInjector;
    assert storageProvider != null;
    this.storageProvider = storageProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
  }

  @Override
  public RegistryPagerPresenterImpl get() {
    return MembersInjectors.injectMembers(
        registryPagerPresenterImplMembersInjector,
        new RegistryPagerPresenterImpl(storageProvider.get(), rxUtilProvider.get()));
  }

  public static Factory<RegistryPagerPresenterImpl> create(
      MembersInjector<RegistryPagerPresenterImpl> registryPagerPresenterImplMembersInjector,
      Provider<Storage> storageProvider,
      Provider<RxUtil> rxUtilProvider) {
    return new RegistryPagerPresenterImpl_Factory(
        registryPagerPresenterImplMembersInjector, storageProvider, rxUtilProvider);
  }
}
