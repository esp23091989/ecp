package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.TasksHelper;
import com.ibis.ibisecp2.helpers.impl.TasksHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideTasksHelperFactory implements Factory<TasksHelper> {
  private final HelperModule module;

  private final Provider<TasksHelperImpl> helperProvider;

  public HelperModule_ProvideTasksHelperFactory(
      HelperModule module, Provider<TasksHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public TasksHelper get() {
    return Preconditions.checkNotNull(
        module.provideTasksHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TasksHelper> create(
      HelperModule module, Provider<TasksHelperImpl> helperProvider) {
    return new HelperModule_ProvideTasksHelperFactory(module, helperProvider);
  }
}
