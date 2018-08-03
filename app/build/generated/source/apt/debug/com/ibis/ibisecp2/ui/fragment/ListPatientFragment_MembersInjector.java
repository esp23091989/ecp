package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.ListPatientPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ListPatientFragment_MembersInjector
    implements MembersInjector<ListPatientFragment> {
  private final Provider<ListPatientPresenter> presenterProvider;

  private final Provider<DialogsHelper> dialogsHelperProvider;

  public ListPatientFragment_MembersInjector(
      Provider<ListPatientPresenter> presenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert dialogsHelperProvider != null;
    this.dialogsHelperProvider = dialogsHelperProvider;
  }

  public static MembersInjector<ListPatientFragment> create(
      Provider<ListPatientPresenter> presenterProvider,
      Provider<DialogsHelper> dialogsHelperProvider) {
    return new ListPatientFragment_MembersInjector(presenterProvider, dialogsHelperProvider);
  }

  @Override
  public void injectMembers(ListPatientFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.dialogsHelper = dialogsHelperProvider.get();
  }

  public static void injectPresenter(
      ListPatientFragment instance, Provider<ListPatientPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectDialogsHelper(
      ListPatientFragment instance, Provider<DialogsHelper> dialogsHelperProvider) {
    instance.dialogsHelper = dialogsHelperProvider.get();
  }
}
