package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import com.ibis.ibisecp2.ui.Navigator;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReminderTimePresenterImpl_Factory implements Factory<ReminderTimePresenterImpl> {
  private final MembersInjector<ReminderTimePresenterImpl> reminderTimePresenterImplMembersInjector;

  private final Provider<Navigator> navigatorProvider;

  private final Provider<VisitLoadHelper> visitLoadHelperProvider;

  public ReminderTimePresenterImpl_Factory(
      MembersInjector<ReminderTimePresenterImpl> reminderTimePresenterImplMembersInjector,
      Provider<Navigator> navigatorProvider,
      Provider<VisitLoadHelper> visitLoadHelperProvider) {
    assert reminderTimePresenterImplMembersInjector != null;
    this.reminderTimePresenterImplMembersInjector = reminderTimePresenterImplMembersInjector;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
    assert visitLoadHelperProvider != null;
    this.visitLoadHelperProvider = visitLoadHelperProvider;
  }

  @Override
  public ReminderTimePresenterImpl get() {
    return MembersInjectors.injectMembers(
        reminderTimePresenterImplMembersInjector,
        new ReminderTimePresenterImpl(navigatorProvider.get(), visitLoadHelperProvider.get()));
  }

  public static Factory<ReminderTimePresenterImpl> create(
      MembersInjector<ReminderTimePresenterImpl> reminderTimePresenterImplMembersInjector,
      Provider<Navigator> navigatorProvider,
      Provider<VisitLoadHelper> visitLoadHelperProvider) {
    return new ReminderTimePresenterImpl_Factory(
        reminderTimePresenterImplMembersInjector, navigatorProvider, visitLoadHelperProvider);
  }
}
