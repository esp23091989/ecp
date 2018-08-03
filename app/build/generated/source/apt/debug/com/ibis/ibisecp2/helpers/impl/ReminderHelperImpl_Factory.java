package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReminderHelperImpl_Factory implements Factory<ReminderHelperImpl> {
  private final Provider<Storage> cupboardProvider;

  private final Provider<RxUtil> rxUtilProvider;

  public ReminderHelperImpl_Factory(
      Provider<Storage> cupboardProvider, Provider<RxUtil> rxUtilProvider) {
    assert cupboardProvider != null;
    this.cupboardProvider = cupboardProvider;
    assert rxUtilProvider != null;
    this.rxUtilProvider = rxUtilProvider;
  }

  @Override
  public ReminderHelperImpl get() {
    return new ReminderHelperImpl(cupboardProvider.get(), rxUtilProvider.get());
  }

  public static Factory<ReminderHelperImpl> create(
      Provider<Storage> cupboardProvider, Provider<RxUtil> rxUtilProvider) {
    return new ReminderHelperImpl_Factory(cupboardProvider, rxUtilProvider);
  }
}
