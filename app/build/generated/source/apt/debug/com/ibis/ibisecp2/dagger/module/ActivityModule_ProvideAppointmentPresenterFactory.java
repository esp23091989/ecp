package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.AppointmentPresenter;
import com.ibis.ibisecp2.presenters.impl.AppointmentPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideAppointmentPresenterFactory
    implements Factory<AppointmentPresenter> {
  private final ActivityModule module;

  private final Provider<AppointmentPresenterImpl> presenterProvider;

  public ActivityModule_ProvideAppointmentPresenterFactory(
      ActivityModule module, Provider<AppointmentPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public AppointmentPresenter get() {
    return Preconditions.checkNotNull(
        module.provideAppointmentPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AppointmentPresenter> create(
      ActivityModule module, Provider<AppointmentPresenterImpl> presenterProvider) {
    return new ActivityModule_ProvideAppointmentPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideAppointmentPresenter(AppointmentPresenterImpl)}. */
  public static AppointmentPresenter proxyProvideAppointmentPresenter(
      ActivityModule instance, AppointmentPresenterImpl presenter) {
    return instance.provideAppointmentPresenter(presenter);
  }
}
