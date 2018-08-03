package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.ReminderTimePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReminderTimeFragment_MembersInjector
    implements MembersInjector<ReminderTimeFragment> {
  private final Provider<ReminderTimePresenter> reminderTimePresenterProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public ReminderTimeFragment_MembersInjector(
      Provider<ReminderTimePresenter> reminderTimePresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert reminderTimePresenterProvider != null;
    this.reminderTimePresenterProvider = reminderTimePresenterProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  public static MembersInjector<ReminderTimeFragment> create(
      Provider<ReminderTimePresenter> reminderTimePresenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new ReminderTimeFragment_MembersInjector(
        reminderTimePresenterProvider, dialogsHelperProvider);
  }

  @Override
  public void injectMembers(ReminderTimeFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.reminderTimePresenter = reminderTimePresenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectReminderTimePresenter(
      ReminderTimeFragment instance,
      Provider<ReminderTimePresenter> reminderTimePresenterProvider) {
    instance.reminderTimePresenter = reminderTimePresenterProvider.get();
  }

  public static void injectDialogsHelper(
      ReminderTimeFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }
}
