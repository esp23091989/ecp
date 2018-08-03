package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideEcpRetrofitFactory implements Factory<Retrofit> {
  private final ApiModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<SharedPreferencesUtils> utilsProvider;

  public ApiModule_ProvideEcpRetrofitFactory(
      ApiModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<SharedPreferencesUtils> utilsProvider) {
    assert module != null;
    this.module = module;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
    assert utilsProvider != null;
    this.utilsProvider = utilsProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideEcpRetrofit(okHttpClientProvider.get(), utilsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(
      ApiModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<SharedPreferencesUtils> utilsProvider) {
    return new ApiModule_ProvideEcpRetrofitFactory(module, okHttpClientProvider, utilsProvider);
  }
}
