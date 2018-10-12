package com.ibis.ibisecp2.retrofit;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by danila on 20.10.16.
 */

public interface ApiEsia {
    @POST("aas/oauth2/ac")
    @FormUrlEncoded
    Observable<ResponseBody> getData(@Field("client_id") String clientId,
                                     @Field("client_secret") String client_secret,
                                     @Field("redirect_uri") String redirect_uri,
                                     @Field("scope") String scope,
                                     @Field("response_type") String response_type,
                                     @Field("state") String state,
                                     @Field("timestamp") String timestamp,
                                     @Field("access_type") String access_type);
}
