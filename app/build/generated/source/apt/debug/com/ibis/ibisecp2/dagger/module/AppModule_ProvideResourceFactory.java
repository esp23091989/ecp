package com.ibis.ibisecp2.dagger.module;

import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideResourceFactory implements Factory<Resources> {
  private final AppModule module;

  public AppModule_ProvideResourceFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Resources get() {
    return Preconditions.checkNotNull(
        module.provideResource(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Resources> create(AppModule module) {
    return new AppModule_ProvideResourceFactory(module);
  }
}
