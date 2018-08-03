package com.ibis.ibisecp2.dagger.module;

import android.location.LocationManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideLocationManagerFactory implements Factory<LocationManager> {
  private final AppModule module;

  public AppModule_ProvideLocationManagerFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public LocationManager get() {
    return Preconditions.checkNotNull(
        module.provideLocationManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LocationManager> create(AppModule module) {
    return new AppModule_ProvideLocationManagerFactory(module);
  }
}
