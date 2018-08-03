package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_MembersInjector implements MembersInjector<ApiModule> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<OkHttpClient> okHttpClientProvider2;

  private final Provider<SharedPreferencesUtils> utilsProvider;

  private final Provider<Retrofit> adapterProvider;

  private final Provider<Retrofit> adapterProvider2;

  private final Provider<Retrofit> adapterProvider3;

  public ApiModule_MembersInjector(
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<OkHttpClient> okHttpClientProvider2,
      Provider<SharedPreferencesUtils> utilsProvider,
      Provider<Retrofit> adapterProvider,
      Provider<Retrofit> adapterProvider2,
      Provider<Retrofit> adapterProvider3) {
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
    assert okHttpClientProvider2 != null;
    this.okHttpClientProvider2 = okHttpClientProvider2;
    assert utilsProvider != null;
    this.utilsProvider = utilsProvider;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert adapterProvider2 != null;
    this.adapterProvider2 = adapterProvider2;
    assert adapterProvider3 != null;
    this.adapterProvider3 = adapterProvider3;
  }

  public static MembersInjector<ApiModule> create(
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<OkHttpClient> okHttpClientProvider2,
      Provider<SharedPreferencesUtils> utilsProvider,
      Provider<Retrofit> adapterProvider,
      Provider<Retrofit> adapterProvider2,
      Provider<Retrofit> adapterProvider3) {
    return new ApiModule_MembersInjector(
        okHttpClientProvider,
        okHttpClientProvider2,
        utilsProvider,
        adapterProvider,
        adapterProvider2,
        adapterProvider3);
  }

  @Override
  public void injectMembers(ApiModule instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.provideOkHttpClientW();
    instance.provideRetrofit(okHttpClientProvider.get());
    instance.provideMedvedRetrofit(okHttpClientProvider2.get());
    instance.provideEcpRetrofit(okHttpClientProvider.get(), utilsProvider.get());
    instance.provideApiClient(adapterProvider.get());
    instance.provideMedvedApi(adapterProvider2.get());
    instance.provideEcpAp(adapterProvider3.get());
  }
}
