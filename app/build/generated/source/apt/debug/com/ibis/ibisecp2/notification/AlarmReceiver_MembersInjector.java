package com.ibis.ibisecp2.notification;

import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmReceiver_MembersInjector implements MembersInjector<AlarmReceiver> {
  private final Provider<VisitLoadHelper> reminderHelperProvider;

  public AlarmReceiver_MembersInjector(Provider<VisitLoadHelper> reminderHelperProvider) {
    assert reminderHelperProvider != null;
    this.reminderHelperProvider = reminderHelperProvider;
  }

  public static MembersInjector<AlarmReceiver> create(
      Provider<VisitLoadHelper> reminderHelperProvider) {
    return new AlarmReceiver_MembersInjector(reminderHelperProvider);
  }

  @Override
  public void injectMembers(AlarmReceiver instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.reminderHelper = reminderHelperProvider.get();
  }

  public static void injectReminderHelper(
      AlarmReceiver instance, Provider<VisitLoadHelper> reminderHelperProvider) {
    instance.reminderHelper = reminderHelperProvider.get();
  }
}
