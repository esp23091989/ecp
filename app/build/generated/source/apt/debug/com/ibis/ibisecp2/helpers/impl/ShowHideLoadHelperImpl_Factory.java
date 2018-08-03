package com.ibis.ibisecp2.helpers.impl;

import android.app.Activity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShowHideLoadHelperImpl_Factory implements Factory<ShowHideLoadHelperImpl> {
  private final Provider<Activity> activityProvider;

  public ShowHideLoadHelperImpl_Factory(Provider<Activity> activityProvider) {
    assert activityProvider != null;
    this.activityProvider = activityProvider;
  }

  @Override
  public ShowHideLoadHelperImpl get() {
    return new ShowHideLoadHelperImpl(activityProvider.get());
  }

  public static Factory<ShowHideLoadHelperImpl> create(Provider<Activity> activityProvider) {
    return new ShowHideLoadHelperImpl_Factory(activityProvider);
  }
}
