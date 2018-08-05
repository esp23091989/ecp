package com.ibis.ibisecp2.retrofit;

import com.ibis.ibisecp2.model.auth.dto.UserInfoResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

public interface EsiaApi {

    @GET("/rs/prns/{userId}")
    Single<UserInfoResponse> getUserInfo(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/ctts")
    Single<String> getContactsIds(@Path("userId") String sbjId);
}
