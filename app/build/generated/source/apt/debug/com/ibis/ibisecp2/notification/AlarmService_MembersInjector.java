package com.ibis.ibisecp2.notification;

import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmService_MembersInjector implements MembersInjector<AlarmService> {
  private final Provider<VisitLoadHelper> visitLoadHelperProvider;

  public AlarmService_MembersInjector(Provider<VisitLoadHelper> visitLoadHelperProvider) {
    assert visitLoadHelperProvider != null;
    this.visitLoadHelperProvider = visitLoadHelperProvider;
  }

  public static MembersInjector<AlarmService> create(
      Provider<VisitLoadHelper> visitLoadHelperProvider) {
    return new AlarmService_MembersInjector(visitLoadHelperProvider);
  }

  @Override
  public void injectMembers(AlarmService instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.visitLoadHelper = visitLoadHelperProvider.get();
  }

  public static void injectVisitLoadHelper(
      AlarmService instance, Provider<VisitLoadHelper> visitLoadHelperProvider) {
    instance.visitLoadHelper = visitLoadHelperProvider.get();
  }
}
