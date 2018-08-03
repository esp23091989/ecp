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
public final class AuthHelperImpl_Factory implements Factory<AuthHelperImpl> {
  private final Provider<EcpAp> apiProvider;

  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EncryptUtils> encryptUtilsProvider;

  public AuthHelperImpl_Factory(
      Provider<EcpAp> apiProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    assert apiProvider != null;
    this.apiProvider = apiProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert encryptUtilsProvider != null;
    this.encryptUtilsProvider = encryptUtilsProvider;
  }

  @Override
  public AuthHelperImpl get() {
    return new AuthHelperImpl(apiProvider.get(), rxUtilProvider.get(), encryptUtilsProvider.get());
  }

  public static Factory<AuthHelperImpl> create(
      Provider<EcpAp> apiProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    return new AuthHelperImpl_Factory(apiProvider, rxUtilProvider, encryptUtilsProvider);
  }
}
