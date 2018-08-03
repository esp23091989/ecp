package com.ibis.ibisecp2.helpers.impl;

import android.app.Activity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProgressDialogHelperImpl_Factory implements Factory<ProgressDialogHelperImpl> {
  private final Provider<Activity> activityProvider;

  public ProgressDialogHelperImpl_Factory(Provider<Activity> activityProvider) {
    assert activityProvider != null;
    this.activityProvider = activityProvider;
  }

  @Override
  public ProgressDialogHelperImpl get() {
    return new ProgressDialogHelperImpl(activityProvider.get());
  }

  public static Factory<ProgressDialogHelperImpl> create(Provider<Activity> activityProvider) {
    return new ProgressDialogHelperImpl_Factory(activityProvider);
  }
}
