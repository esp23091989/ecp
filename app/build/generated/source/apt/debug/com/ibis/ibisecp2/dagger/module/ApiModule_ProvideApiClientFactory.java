package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.retrofit.ApiEsia;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideApiClientFactory implements Factory<ApiEsia> {
  private final ApiModule module;

  private final Provider<Retrofit> adapterProvider;

  public ApiModule_ProvideApiClientFactory(ApiModule module, Provider<Retrofit> adapterProvider) {
    assert module != null;
    this.module = module;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
  }

  @Override
  public ApiEsia get() {
    return Preconditions.checkNotNull(
        module.provideApiClient(adapterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiEsia> create(ApiModule module, Provider<Retrofit> adapterProvider) {
    return new ApiModule_ProvideApiClientFactory(module, adapterProvider);
  }
}
