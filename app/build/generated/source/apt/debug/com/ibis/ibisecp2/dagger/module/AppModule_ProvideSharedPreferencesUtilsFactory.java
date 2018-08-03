package com.ibis.ibisecp2.dagger.module;

import android.content.SharedPreferences;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideSharedPreferencesUtilsFactory
    implements Factory<SharedPreferencesUtils> {
  private final AppModule module;

  private final Provider<SharedPreferences> prefsProvider;

  public AppModule_ProvideSharedPreferencesUtilsFactory(
      AppModule module, Provider<SharedPreferences> prefsProvider) {
    assert module != null;
    this.module = module;
    assert prefsProvider != null;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public SharedPreferencesUtils get() {
    return Preconditions.checkNotNull(
        module.provideSharedPreferencesUtils(prefsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SharedPreferencesUtils> create(
      AppModule module, Provider<SharedPreferences> prefsProvider) {
    return new AppModule_ProvideSharedPreferencesUtilsFactory(module, prefsProvider);
  }

  /** Proxies {@link AppModule#provideSharedPreferencesUtils(SharedPreferences)}. */
  public static SharedPreferencesUtils proxyProvideSharedPreferencesUtils(
      AppModule instance, SharedPreferences prefs) {
    return instance.provideSharedPreferencesUtils(prefs);
  }
}
