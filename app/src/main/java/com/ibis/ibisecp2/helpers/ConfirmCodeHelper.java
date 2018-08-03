package com.ibis.ibisecp2.helpers;

import com.ibis.ibisecp2.model.AuthResponse;

import rx.Observable;

/**
 * Created by comp on 21.03.17.
 */

public interface ConfirmCodeHelper {
    Observable<AuthResponse> confirm(String login, String password, String idType);
}
