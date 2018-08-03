package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UtilsModule_ProvideEncryptUtilsFactory implements Factory<EncryptUtils> {
  private final UtilsModule module;

  private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;

  public UtilsModule_ProvideEncryptUtilsFactory(
      UtilsModule module, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
    assert module != null;
    this.module = module;
    assert sharedPreferencesUtilsProvider != null;
    this.sharedPreferencesUtilsProvider = sharedPreferencesUtilsProvider;
  }

  @Override
  public EncryptUtils get() {
    return Preconditions.checkNotNull(
        module.provideEncryptUtils(sharedPreferencesUtilsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<EncryptUtils> create(
      UtilsModule module, Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider) {
    return new UtilsModule_ProvideEncryptUtilsFactory(module, sharedPreferencesUtilsProvider);
  }
}
