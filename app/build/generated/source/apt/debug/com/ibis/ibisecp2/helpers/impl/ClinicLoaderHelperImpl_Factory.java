package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClinicLoaderHelperImpl_Factory implements Factory<ClinicLoaderHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EcpAp> ecpApProvider;

  public ClinicLoaderHelperImpl_Factory(
      Provider<RxUtil> rxUtilProvider, Provider<EcpAp> ecpApProvider) {
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert ecpApProvider != null;
    this.ecpApProvider = ecpApProvider;
  }

  @Override
  public ClinicLoaderHelperImpl get() {
    return new ClinicLoaderHelperImpl(rxUtilProvider.get(), ecpApProvider.get());
  }

  public static Factory<ClinicLoaderHelperImpl> create(
      Provider<RxUtil> rxUtilProvider, Provider<EcpAp> ecpApProvider) {
    return new ClinicLoaderHelperImpl_Factory(rxUtilProvider, ecpApProvider);
  }
}
