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
public final class TestPostHelperImpl_Factory implements Factory<TestPostHelperImpl> {
  private final Provider<EcpAp> ecpApiProvider;

  private final Provider<RxUtil> rxUtilProvider;

  public TestPostHelperImpl_Factory(
      Provider<EcpAp> ecpApiProvider, Provider<RxUtil> rxUtilProvider) {
    assert ecpApiProvider != null;
    this.ecpApiProvider = ecpApiProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
  }

  @Override
  public TestPostHelperImpl get() {
    return new TestPostHelperImpl(ecpApiProvider.get(), rxUtilProvider.get());
  }

  public static Factory<TestPostHelperImpl> create(
      Provider<EcpAp> ecpApiProvider, Provider<RxUtil> rxUtilProvider) {
    return new TestPostHelperImpl_Factory(ecpApiProvider, rxUtilProvider);
  }
}
