package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.ConfirmSmsPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ConfirmSmsFragment_MembersInjector
    implements MembersInjector<ConfirmSmsFragment> {
  private final Provider<ConfirmSmsPresenter> presenterProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public ConfirmSmsFragment_MembersInjector(
      Provider<ConfirmSmsPresenter> presenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  public static MembersInjector<ConfirmSmsFragment> create(
      Provider<ConfirmSmsPresenter> presenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new ConfirmSmsFragment_MembersInjector(presenterProvider, dialogsHelperProvider);
  }

  @Override
  public void injectMembers(ConfirmSmsFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectPresenter(
      ConfirmSmsFragment instance, Provider<ConfirmSmsPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectDialogsHelper(
      ConfirmSmsFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }
}
