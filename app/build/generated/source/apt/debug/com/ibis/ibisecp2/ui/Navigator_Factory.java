package com.ibis.ibisecp2.ui;

import android.app.Activity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Navigator_Factory implements Factory<Navigator> {
  private final Provider<Activity> activityProvider;

  public Navigator_Factory(Provider<Activity> activityProvider) {
    assert activityProvider != null;
    this.activityProvider = activityProvider;
  }

  @Override
  public Navigator get() {
    return new Navigator(activityProvider.get());
  }

  public static Factory<Navigator> create(Provider<Activity> activityProvider) {
    return new Navigator_Factory(activityProvider);
  }
}
