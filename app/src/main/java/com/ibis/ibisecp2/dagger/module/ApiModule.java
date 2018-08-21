package com.ibis.ibisecp2.dagger.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ibis.ibisecp2.BuildConfig;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.retrofit.ApiEsia;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.retrofit.EsiaApi;
import com.ibis.ibisecp2.retrofit.MedvedApi;
import com.ibis.ibisecp2.retrofit.TLSSocketFactory;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by danila on 20.10.16.
 */
@Module
public class ApiModule {
    private final static String BASE_URL = "https://esia.gosuslugi.ru/";
    private final static String BASE_URL_MEDVED = "https://medved-webservices.hostco.ru/DLORecipeService/services/recipeService/";
    private static final String BASE_URL_ECP_TEST = "http://ecp.miacugra.ru:8008/AndroidService.svc/";
    private static final String BASE_URL_ECP_PROD = "http://ecp.miacugra.ru/AndroidService.svc/";
    private static final String BASE_URL_ECP_PROD_v2 = "https://ecp.miacugra.ru/";
    private static final String BASE_URL_ECP_HTTPS = "https://192.168.1.41/";
    private static final String BASE_URL_TEST = "http://95.174.103.205:18000/";
    private static final String BASE_URL_TESTS = "http://tgn.oblteh.ru:10081/IbisECPService/";
    private static final String BASE_URL_MIAC = "https://ecp-test.miacugra.ru/";
    private static final String BASE_URL_ESIA = "https://esia-portal1.test.gosuslugi.ru/";

    @Provides
    @Singleton
    @Inject
    @Named("OkHttpClient")
    public OkHttpClient provideOkHttpClientW() {

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()//.addInterceptor(interceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @Inject
    @Named("EsiaOkHttpClient")
    public OkHttpClient provideEsiaOkHttpClient(SharedPreferencesUtils sharedPreferencesUtils){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        clientBuilder.addNetworkInterceptor(interceptor);
        clientBuilder.addInterceptor(chain -> {
            Request request = chain.request();
            EsiaTokenMarker esiaTokenMarker = sharedPreferencesUtils.getEsiaMarker();

            Request.Builder requestBuilder = request.newBuilder()
                    .header("Authorization", "Bearer " + esiaTokenMarker.getAccessToken());
            return chain.proceed(requestBuilder.build());
        });

        try {
            clientBuilder.sslSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault(), new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            });
            clientBuilder.hostnameVerifier((hostname, session) -> true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return clientBuilder.build();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Context context) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
// Create a trust manager that does not validate certificate chains
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            final SSLSocketFactory sslSocketFactory = new TLSSocketFactory();
            HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
//        final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            builder.addInterceptor(interceptor)
//                    .addNetworkInterceptor(new StethoInterceptor())
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS);
            return builder.build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return new OkHttpClient.Builder().addInterceptor(interceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @Inject
    @Named("apiClient")
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return getRetrofit(okHttpClient, BASE_URL);
    }

    @Provides
    @Singleton
    @Inject
    @Named("EsiaRetrofitClient")
    public Retrofit provideEsiaRetrofit(@Named("EsiaOkHttpClient") OkHttpClient okHttpClient){
        return getRetrofit(okHttpClient, BASE_URL_ESIA);
    }

    @Provides
    @Singleton
    @Inject
    @Named("MedvedClient")
    public Retrofit provideMedvedRetrofit(@Named("OkHttpClient") OkHttpClient okHttpClient) {
        return getRetrofit(okHttpClient, BASE_URL_MEDVED);
    }

    @Provides
    @Singleton
    @Inject
    @Named("EcpClient")
    public Retrofit provideEcpRetrofit(OkHttpClient okHttpClient, SharedPreferencesUtils utils) {
        String url;
        if (BuildConfig.DEBUG) {
            url = utils.getUrl().equals("") ? BASE_URL_TESTS : utils.getUrl();
        } else {
            url = BASE_URL_ECP_PROD_v2;
        }

        return new Retrofit.Builder()
                .baseUrl(url) //BASE_URL_ECP_HTTPS - BASE_URL_ECP_PROD_v2
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @NonNull
    private Retrofit getRetrofit(OkHttpClient okHttpClient, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Inject
    public ApiEsia provideApiClient(@Named("apiClient") Retrofit adapter) {
        return adapter.create(ApiEsia.class);
    }

    @Provides
    @Singleton
    @Inject
    public MedvedApi provideMedvedApi(@Named("MedvedClient") Retrofit adapter) {
        return adapter.create(MedvedApi.class);
    }

    @Provides
    @Singleton
    @Inject
    public EcpAp provideEcpAp(@Named("EcpClient") Retrofit adapter) {
        return adapter.create(EcpAp.class);
    }

    @Provides
    @Singleton
    @Inject
    public EsiaApi provideEsiaApi(@Named("EsiaRetrofitClient") Retrofit adpter){
        return adpter.create(EsiaApi.class);
    }


}
