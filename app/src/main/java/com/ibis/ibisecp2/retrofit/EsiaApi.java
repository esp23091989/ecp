package com.ibis.ibisecp2.retrofit;

import com.ibis.ibisecp2.model.ContactInfoResponse;
import com.ibis.ibisecp2.model.ContactsListResponse;
import com.ibis.ibisecp2.model.auth.dto.UserInfoResponse;

import rx.Observable;
import rx.Single;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EsiaApi {

    @GET("/rs/prns/{userId}")
    Single<UserInfoResponse> getUserInfo(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/ctts")
    Observable<ContactsListResponse> getContactsList(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/ctts/{cttsId}")
    Observable<ContactInfoResponse> getContactById(@Path("userId") String sbjid, @Path("cttsId") String contactId);
}
