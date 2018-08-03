package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.MedicamentFindHelper;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MedicamentFindPresenterImpl_Factory
    implements Factory<MedicamentFindPresenterImpl> {
  private final MembersInjector<MedicamentFindPresenterImpl>
      medicamentFindPresenterImplMembersInjector;

  private final Provider<DialogsHelper> helperProvider;

  private final Provider<MedicamentFindHelper> medicamentFindHelperProvider;

  public MedicamentFindPresenterImpl_Factory(
      MembersInjector<MedicamentFindPresenterImpl> medicamentFindPresenterImplMembersInjector,
      Provider<DialogsHelper> helperProvider,
      Provider<MedicamentFindHelper> medicamentFindHelperProvider) {
    assert medicamentFindPresenterImplMembersInjector != null;
    this.medicamentFindPresenterImplMembersInjector = medicamentFindPresenterImplMembersInjector;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
    assert medicamentFindHelperProvider != null;
    this.medicamentFindHelperProvider = medicamentFindHelperProvider;
  }

  @Override
  public MedicamentFindPresenterImpl get() {
    return MembersInjectors.injectMembers(
        medicamentFindPresenterImplMembersInjector,
        new MedicamentFindPresenterImpl(helperProvider.get(), medicamentFindHelperProvider.get()));
  }

  public static Factory<MedicamentFindPresenterImpl> create(
      MembersInjector<MedicamentFindPresenterImpl> medicamentFindPresenterImplMembersInjector,
      Provider<DialogsHelper> helperProvider,
      Provider<MedicamentFindHelper> medicamentFindHelperProvider) {
    return new MedicamentFindPresenterImpl_Factory(
        medicamentFindPresenterImplMembersInjector, helperProvider, medicamentFindHelperProvider);
  }
}
