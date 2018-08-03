package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ChangeVisitHelperImpl_Factory implements Factory<ChangeVisitHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EcpAp> ecpApProvider;

  private final Provider<EncryptUtils> encryptUtilsProvider;

  private final Provider<Storage> cupboardProvider;

  public ChangeVisitHelperImpl_Factory(
      Provider<RxUtil> rxUtilProvider,
      Provider<EcpAp> ecpApProvider,
      Provider<EncryptUtils> encryptUtilsProvider,
      Provider<Storage> cupboardProvider) {
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert ecpApProvider != null;
    this.ecpApProvider = ecpApProvider;
    assert encryptUtilsProvider != null;
    this.encryptUtilsProvider = encryptUtilsProvider;
    assert cupboardProvider != null;
    this.cupboardProvider = cupboardProvider;
  }

  @Override
  public ChangeVisitHelperImpl get() {
    return new ChangeVisitHelperImpl(
        rxUtilProvider.get(),
        ecpApProvider.get(),
        encryptUtilsProvider.get(),
        cupboardProvider.get());
  }

  public static Factory<ChangeVisitHelperImpl> create(
      Provider<RxUtil> rxUtilProvider,
      Provider<EcpAp> ecpApProvider,
      Provider<EncryptUtils> encryptUtilsProvider,
      Provider<Storage> cupboardProvider) {
    return new ChangeVisitHelperImpl_Factory(
        rxUtilProvider, ecpApProvider, encryptUtilsProvider, cupboardProvider);
  }
}
