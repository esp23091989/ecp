package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ScheduleLoaderHelper;
import com.ibis.ibisecp2.helpers.impl.ScheduleLoaderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideScheduleLoaderHelperFactory
    implements Factory<ScheduleLoaderHelper> {
  private final HelperModule module;

  private final Provider<ScheduleLoaderHelperImpl> helperProvider;

  public HelperModule_ProvideScheduleLoaderHelperFactory(
      HelperModule module, Provider<ScheduleLoaderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ScheduleLoaderHelper get() {
    return Preconditions.checkNotNull(
        module.provideScheduleLoaderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ScheduleLoaderHelper> create(
      HelperModule module, Provider<ScheduleLoaderHelperImpl> helperProvider) {
    return new HelperModule_ProvideScheduleLoaderHelperFactory(module, helperProvider);
  }
}
