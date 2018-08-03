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
public final class ScheduleLoaderHelperImpl_Factory implements Factory<ScheduleLoaderHelperImpl> {
  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EcpAp> ecpApProvider;

  public ScheduleLoaderHelperImpl_Factory(
      Provider<RxUtil> rxUtilProvider, Provider<EcpAp> ecpApProvider) {
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
    assert ecpApProvider != null;
    this.ecpApProvider = ecpApProvider;
  }

  @Override
  public ScheduleLoaderHelperImpl get() {
    return new ScheduleLoaderHelperImpl(rxUtilProvider.get(), ecpApProvider.get());
  }

  public static Factory<ScheduleLoaderHelperImpl> create(
      Provider<RxUtil> rxUtilProvider, Provider<EcpAp> ecpApProvider) {
    return new ScheduleLoaderHelperImpl_Factory(rxUtilProvider, ecpApProvider);
  }
}
