package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.MedicamentFindPresenter;
import com.ibis.ibisecp2.presenters.impl.MedicamentFindPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideMedicamentFindPresenterFactory
    implements Factory<MedicamentFindPresenter> {
  private final ActivityModule module;

  private final Provider<MedicamentFindPresenterImpl> presenterProvider;

  public ActivityModule_ProvideMedicamentFindPresenterFactory(
      ActivityModule module, Provider<MedicamentFindPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public MedicamentFindPresenter get() {
    return Preconditions.checkNotNull(
        module.provideMedicamentFindPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MedicamentFindPresenter> create(
      ActivityModule module, Provider<MedicamentFindPresenterImpl> presenterProvider) {
    return new ActivityModule_ProvideMedicamentFindPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideMedicamentFindPresenter(MedicamentFindPresenterImpl)}. */
  public static MedicamentFindPresenter proxyProvideMedicamentFindPresenter(
      ActivityModule instance, MedicamentFindPresenterImpl presenter) {
    return instance.provideMedicamentFindPresenter(presenter);
  }
}
