package com.ibis.ibisecp2.notification;

import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmSetter_MembersInjector implements MembersInjector<AlarmSetter> {
  private final Provider<VisitLoadHelper> reminderHelperProvider;

  public AlarmSetter_MembersInjector(Provider<VisitLoadHelper> reminderHelperProvider) {
    assert reminderHelperProvider != null;
    this.reminderHelperProvider = reminderHelperProvider;
  }

  public static MembersInjector<AlarmSetter> create(
      Provider<VisitLoadHelper> reminderHelperProvider) {
    return new AlarmSetter_MembersInjector(reminderHelperProvider);
  }

  @Override
  public void injectMembers(AlarmSetter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.reminderHelper = reminderHelperProvider.get();
  }

  public static void injectReminderHelper(
      AlarmSetter instance, Provider<VisitLoadHelper> reminderHelperProvider) {
    instance.reminderHelper = reminderHelperProvider.get();
  }
}
