package com.ibis.ibisecp2.retrofit;

import com.ibis.ibisecp2.model.ContactInfoResponse;
import com.ibis.ibisecp2.model.ContactsListResponse;
import com.ibis.ibisecp2.model.auth.dto.UserInfoResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

public interface EsiaApi {

    @GET("/rs/prns/{userId}")
    Single<UserInfoResponse> getUserInfo(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/ctts")
    Single<ContactsListResponse> getContactsInfo(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/ctts/{cttsId}")
    Single<ContactInfoResponse> getContactById(@Path("userId") String sbjid, @Path("cttsId") String contactId);
}
