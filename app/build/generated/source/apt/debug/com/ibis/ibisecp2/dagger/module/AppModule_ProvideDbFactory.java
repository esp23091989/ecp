package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.storage.Storage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideDbFactory implements Factory<Storage> {
  private final AppModule module;

  public AppModule_ProvideDbFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Storage get() {
    return Preconditions.checkNotNull(
        module.provideDb(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Storage> create(AppModule module) {
    return new AppModule_ProvideDbFactory(module);
  }

  /** Proxies {@link AppModule#provideDb()}. */
  public static Storage proxyProvideDb(AppModule instance) {
    return instance.provideDb();
  }
}
