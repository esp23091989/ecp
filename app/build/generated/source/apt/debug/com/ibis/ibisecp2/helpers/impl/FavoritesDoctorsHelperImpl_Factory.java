package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FavoritesDoctorsHelperImpl_Factory
    implements Factory<FavoritesDoctorsHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<Storage> storageProvider;

  public FavoritesDoctorsHelperImpl_Factory(
      Provider<RxUtil> rxUtilProvider, Provider<Storage> storageProvider) {
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert storageProvider != null;
    this.storageProvider = storageProvider;
  }

  @Override
  public FavoritesDoctorsHelperImpl get() {
    return new FavoritesDoctorsHelperImpl(rxUtilProvider.get(), storageProvider.get());
  }

  public static Factory<FavoritesDoctorsHelperImpl> create(
      Provider<RxUtil> rxUtilProvider, Provider<Storage> storageProvider) {
    return new FavoritesDoctorsHelperImpl_Factory(rxUtilProvider, storageProvider);
  }
}
