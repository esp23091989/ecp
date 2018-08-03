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
public final class DiaryRecordsLoaderHelperImpl_Factory
    implements Factory<DiaryRecordsLoaderHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EcpAp> ecpApProvider;

  private final Provider<EncryptUtils> encryptUtilsProvider;

  public DiaryRecordsLoaderHelperImpl_Factory(
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
  public DiaryRecordsLoaderHelperImpl get() {
    return new DiaryRecordsLoaderHelperImpl(
        rxUtilProvider.get(), ecpApProvider.get(), encryptUtilsProvider.get());
  }

  public static Factory<DiaryRecordsLoaderHelperImpl> create(
      Provider<RxUtil> rxUtilProvider,
      Provider<EcpAp> ecpApProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    return new DiaryRecordsLoaderHelperImpl_Factory(
        rxUtilProvider, ecpApProvider, encryptUtilsProvider);
  }
}
