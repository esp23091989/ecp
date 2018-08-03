package com.ibis.ibisecp2.dagger.module;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UtilsModule_ProvideSharedPreferencesFactory
    implements Factory<SharedPreferences> {
  private final UtilsModule module;

  private final Provider<Application> appProvider;

  public UtilsModule_ProvideSharedPreferencesFactory(
      UtilsModule module, Provider<Application> appProvider) {
    assert module != null;
    this.module = module;
    assert appProvider != null;
    this.appProvider = appProvider;
  }

  @Override
  public SharedPreferences get() {
    return Preconditions.checkNotNull(
        module.provideSharedPreferences(appProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SharedPreferences> create(
      UtilsModule module, Provider<Application> appProvider) {
    return new UtilsModule_ProvideSharedPreferencesFactory(module, appProvider);
  }

  /** Proxies {@link UtilsModule#provideSharedPreferences(Application)}. */
  public static SharedPreferences proxyProvideSharedPreferences(
      UtilsModule instance, Application app) {
    return instance.provideSharedPreferences(app);
  }
}
