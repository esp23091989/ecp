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
public final class ChangeDiaryHelperImpl_Factory implements Factory<ChangeDiaryHelperImpl> {
  private final Provider<EcpAp> ecpApiProvider;

  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EncryptUtils> encryptUtilsProvider;

  public ChangeDiaryHelperImpl_Factory(
      Provider<EcpAp> ecpApiProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    assert ecpApiProvider != null;
    this.ecpApiProvider = ecpApiProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert encryptUtilsProvider != null;
    this.encryptUtilsProvider = encryptUtilsProvider;
  }

  @Override
  public ChangeDiaryHelperImpl get() {
    return new ChangeDiaryHelperImpl(
        ecpApiProvider.get(), rxUtilProvider.get(), encryptUtilsProvider.get());
  }

  public static Factory<ChangeDiaryHelperImpl> create(
      Provider<EcpAp> ecpApiProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    return new ChangeDiaryHelperImpl_Factory(ecpApiProvider, rxUtilProvider, encryptUtilsProvider);
  }
}
