package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.utils.RxUtil;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UtilsModule_ProvideRxUtilFactory implements Factory<RxUtil> {
  private final UtilsModule module;

  public UtilsModule_ProvideRxUtilFactory(UtilsModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public RxUtil get() {
    return Preconditions.checkNotNull(
        module.provideRxUtil(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RxUtil> create(UtilsModule module) {
    return new UtilsModule_ProvideRxUtilFactory(module);
  }
}
