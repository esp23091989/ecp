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
public final class TasksHelperImpl_Factory implements Factory<TasksHelperImpl> {
  private final Provider<EcpAp> ecpApiProvider;

  private final Provider<RxUtil> rxUtilProvider;

  private final Provider<EncryptUtils> encryptUtilsProvider;

  public TasksHelperImpl_Factory(
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
  public TasksHelperImpl get() {
    return new TasksHelperImpl(
        ecpApiProvider.get(), rxUtilProvider.get(), encryptUtilsProvider.get());
  }

  public static Factory<TasksHelperImpl> create(
      Provider<EcpAp> ecpApiProvider,
      Provider<RxUtil> rxUtilProvider,
      Provider<EncryptUtils> encryptUtilsProvider) {
    return new TasksHelperImpl_Factory(ecpApiProvider, rxUtilProvider, encryptUtilsProvider);
  }
}
