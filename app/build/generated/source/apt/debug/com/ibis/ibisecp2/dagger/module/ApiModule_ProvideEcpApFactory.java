package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.retrofit.EcpAp;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideEcpApFactory implements Factory<EcpAp> {
  private final ApiModule module;

  private final Provider<Retrofit> adapterProvider;

  public ApiModule_ProvideEcpApFactory(ApiModule module, Provider<Retrofit> adapterProvider) {
    assert module != null;
    this.module = module;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
  }

  @Override
  public EcpAp get() {
    return Preconditions.checkNotNull(
        module.provideEcpAp(adapterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<EcpAp> create(ApiModule module, Provider<Retrofit> adapterProvider) {
    return new ApiModule_ProvideEcpApFactory(module, adapterProvider);
  }
}
