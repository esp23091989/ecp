package com.ibis.ibisecp2.dagger.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  private final Provider<Context> contextProvider;

  public ApiModule_ProvideOkHttpClientFactory(ApiModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClient(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(ApiModule module, Provider<Context> contextProvider) {
    return new ApiModule_ProvideOkHttpClientFactory(module, contextProvider);
  }
}
