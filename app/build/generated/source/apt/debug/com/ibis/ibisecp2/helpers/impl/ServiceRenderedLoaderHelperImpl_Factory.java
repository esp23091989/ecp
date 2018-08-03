package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ServiceRenderedLoaderHelperImpl_Factory
    implements Factory<ServiceRenderedLoaderHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EcpAp> ecpApProvider;

  private final Provider<EncryptUtils> encryptUtilsProvider;

  public ServiceRenderedLoaderHelperImpl_Factory(
      Provider<RxUtil> rxUtilProvider,
      Provider<EcpAp> ecpApProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert ecpApProvider != null;
    this.ecpApProvider = ecpApProvider;
    assert encryptUtilsProvider != null;
    this.encryptUtilsProvider = encryptUtilsProvider;
  }

  @Override
  public ServiceRenderedLoaderHelperImpl get() {
    return new ServiceRenderedLoaderHelperImpl(
        rxUtilProvider.get(), ecpApProvider.get(), encryptUtilsProvider.get());
  }

  public static Factory<ServiceRenderedLoaderHelperImpl> create(
      Provider<RxUtil> rxUtilProvider,
      Provider<EcpAp> ecpApProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    return new ServiceRenderedLoaderHelperImpl_Factory(
        rxUtilProvider, ecpApProvider, encryptUtilsProvider);
  }
}
