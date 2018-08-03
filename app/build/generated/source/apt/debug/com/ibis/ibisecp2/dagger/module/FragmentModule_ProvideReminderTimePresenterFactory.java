package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.ReminderTimePresenter;
import com.ibis.ibisecp2.presenters.impl.ReminderTimePresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideReminderTimePresenterFactory
    implements Factory<ReminderTimePresenter> {
  private final FragmentModule module;

  private final Provider<ReminderTimePresenterImpl> presenterProvider;

  public FragmentModule_ProvideReminderTimePresenterFactory(
      FragmentModule module, Provider<ReminderTimePresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public ReminderTimePresenter get() {
    return Preconditions.checkNotNull(
        module.provideReminderTimePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ReminderTimePresenter> create(
      FragmentModule module, Provider<ReminderTimePresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideReminderTimePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideReminderTimePresenter(ReminderTimePresenterImpl)}. */
  public static ReminderTimePresenter proxyProvideReminderTimePresenter(
      FragmentModule instance, ReminderTimePresenterImpl presenter) {
    return instance.provideReminderTimePresenter(presenter);
  }
}
