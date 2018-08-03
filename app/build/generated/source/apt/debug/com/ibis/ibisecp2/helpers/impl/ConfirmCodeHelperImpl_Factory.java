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
public final class ConfirmCodeHelperImpl_Factory implements Factory<ConfirmCodeHelperImpl> {
  private final Provider<EcpAp> apiProvider;

  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EncryptUtils> encryptUtilsProvider;

  public ConfirmCodeHelperImpl_Factory(
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
  public ConfirmCodeHelperImpl get() {
    return new ConfirmCodeHelperImpl(
        apiProvider.get(), rxUtilProvider.get(), encryptUtilsProvider.get());
  }

  public static Factory<ConfirmCodeHelperImpl> create(
      Provider<EcpAp> apiProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    return new ConfirmCodeHelperImpl_Factory(apiProvider, rxUtilProvider, encryptUtilsProvider);
  }
}
