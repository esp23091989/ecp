package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.utils.DistanceUtil;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UtilsModule_ProvideDistanceUtilFactory implements Factory<DistanceUtil> {
  private final UtilsModule module;

  public UtilsModule_ProvideDistanceUtilFactory(UtilsModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public DistanceUtil get() {
    return Preconditions.checkNotNull(
        module.provideDistanceUtil(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DistanceUtil> create(UtilsModule module) {
    return new UtilsModule_ProvideDistanceUtilFactory(module);
  }
}
