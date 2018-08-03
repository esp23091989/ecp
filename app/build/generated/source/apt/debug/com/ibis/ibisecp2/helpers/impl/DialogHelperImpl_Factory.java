package com.ibis.ibisecp2.helpers.impl;

import android.app.Activity;
import com.ibis.ibisecp2.ui.Navigator;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DialogHelperImpl_Factory implements Factory<DialogHelperImpl> {
  private final Provider<Activity> activityProvider;

  private final Provider<Navigator> navigatorProvider;

  public DialogHelperImpl_Factory(
      Provider<Activity> activityProvider, Provider<Navigator> navigatorProvider) {
    assert activityProvider != null;
    this.activityProvider = activityProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public DialogHelperImpl get() {
    return new DialogHelperImpl(activityProvider.get(), navigatorProvider.get());
  }

  public static Factory<DialogHelperImpl> create(
      Provider<Activity> activityProvider, Provider<Navigator> navigatorProvider) {
    return new DialogHelperImpl_Factory(activityProvider, navigatorProvider);
  }
}
