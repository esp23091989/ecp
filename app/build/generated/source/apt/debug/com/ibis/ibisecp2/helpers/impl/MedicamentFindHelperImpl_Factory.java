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
public final class MedicamentFindHelperImpl_Factory implements Factory<MedicamentFindHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EcpAp> ecpApProvider;

  public MedicamentFindHelperImpl_Factory(
      Provider<RxUtil> rxUtilProvider, Provider<EcpAp> ecpApProvider) {
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert ecpApProvider != null;
    this.ecpApProvider = ecpApProvider;
  }

  @Override
  public MedicamentFindHelperImpl get() {
    return new MedicamentFindHelperImpl(rxUtilProvider.get(), ecpApProvider.get());
  }

  public static Factory<MedicamentFindHelperImpl> create(
      Provider<RxUtil> rxUtilProvider, Provider<EcpAp> ecpApProvider) {
    return new MedicamentFindHelperImpl_Factory(rxUtilProvider, ecpApProvider);
  }
}
