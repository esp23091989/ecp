package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.EsiaTokenMarker;

import rx.Observable;
import rx.Single;

/**
 * Created by danila on 20.10.16.
 */

public interface AuthHelper {
    Observable<AuthResponse> auth(String login, String password, String idType);

    Single<AuthResponse> auth(EsiaTokenMarker marker);
}
