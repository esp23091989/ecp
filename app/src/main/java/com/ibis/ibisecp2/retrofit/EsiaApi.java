package com.ibis.ibisecp2.retrofit;

import com.ibis.ibisecp2.model.auth.dto.ContactInfoResponse;
import com.ibis.ibisecp2.model.auth.dto.ContactsListResponse;
import com.ibis.ibisecp2.model.auth.dto.KidsListResponse;
import com.ibis.ibisecp2.model.auth.dto.UserInfoDTO;
import com.ibis.ibisecp2.model.auth.dto.UserInfoResponse;

import rx.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

public interface EsiaApi {

    @GET("/rs/prns/{userId}")
    Observable<UserInfoResponse> getUserInfo(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/ctts")
    Observable<ContactsListResponse> getContactsList(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/ctts/{cttsId}")
    Observable<ContactInfoResponse> getContactById(@Path("userId") String sbjid, @Path("cttsId") String contactId);

    @GET("/rs/prns/{userId}/kids")
    Observable<KidsListResponse> getKidById(@Path("userId") String sbjId);

    @GET("/rs/prns/{userId}/kids/{kidId}")
    Observable<UserInfoResponse> getKidById(@Path("userId") String sbjId, @Path("kidId") String kidId);

    @GET("/rs/prns/{userId}/?embed=(contacts.elements, kids.elements)")
    Single<UserInfoDTO> getAllUserInfo(@Path("userId") String userId);
}
