package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.AuthResponse;

import rx.Observable;

/**
 * Created by danila on 20.10.16.
 */

public interface AuthHelper {
    Observable<AuthResponse> auth(String login, String password, String idType);
}
