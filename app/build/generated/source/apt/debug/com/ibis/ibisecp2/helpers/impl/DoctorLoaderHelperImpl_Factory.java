package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DoctorLoaderHelperImpl_Factory implements Factory<DoctorLoaderHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EcpAp> ecpApProvider;

  private final Provider<Storage> storageProvider;

  public DoctorLoaderHelperImpl_Factory(
      Provider<RxUtil> rxUtilProvider,
      Provider<EcpAp> ecpApProvider,
      Provider<Storage> storageProvider) {
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert ecpApProvider != null;
    this.ecpApProvider = ecpApProvider;
    assert storageProvider != null;
    this.storageProvider = storageProvider;
  }

  @Override
  public DoctorLoaderHelperImpl get() {
    return new DoctorLoaderHelperImpl(
        rxUtilProvider.get(), ecpApProvider.get(), storageProvider.get());
  }

  public static Factory<DoctorLoaderHelperImpl> create(
      Provider<RxUtil> rxUtilProvider,
      Provider<EcpAp> ecpApProvider,
      Provider<Storage> storageProvider) {
    return new DoctorLoaderHelperImpl_Factory(rxUtilProvider, ecpApProvider, storageProvider);
  }
}
