package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ReminderHelper;
import com.ibis.ibisecp2.helpers.impl.ReminderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideReminderHelperFactory implements Factory<ReminderHelper> {
  private final HelperModule module;

  private final Provider<ReminderHelperImpl> helperProvider;

  public HelperModule_ProvideReminderHelperFactory(
      HelperModule module, Provider<ReminderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ReminderHelper get() {
    return Preconditions.checkNotNull(
        module.provideReminderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ReminderHelper> create(
      HelperModule module, Provider<ReminderHelperImpl> helperProvider) {
    return new HelperModule_ProvideReminderHelperFactory(module, helperProvider);
  }
}
