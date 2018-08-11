package com.ibis.ibisecp2.helpers.impl;

import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.auth.dto.ContactsListResponse;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.model.auth.dto.KidsListResponse;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.retrofit.EsiaApi;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.rx.mappers.ChildrenMapper;
import com.ibis.ibisecp2.utils.rx.zippers.AuthResponseZipper;

import javax.inject.Inject;

import rx.Observable;
import rx.Single;

/**
 * Created by danila on 20.10.16.
 */

public class AuthHelperImpl implements AuthHelper {

    private RxUtil rxUtil;
    private EcpAp api;
    private final EsiaApi esiaApi;
    private EncryptUtils encryptUtils;
    private final AuthResponseZipper authResponseZipper;
    private final ChildrenMapper childrenMapper;

    @Inject
    public AuthHelperImpl(
            EcpAp api,
            EsiaApi esiaApi,
            RxUtil rxUtil,
            EncryptUtils encryptUtils,
            AuthResponseZipper authResponseZipper,
            ChildrenMapper childrenMapper) {
        this.api = api;
        this.rxUtil = rxUtil;
        this.esiaApi = esiaApi;
        this.encryptUtils = encryptUtils;
        this.authResponseZipper = authResponseZipper;
        this.childrenMapper = childrenMapper;
    }

    @Override
    public Observable<AuthResponse> auth(String login, String password, String idType) {
        return api.auth(encryptUtils.encryptLogin(login, password, idType))
                .compose(rxUtil.applySchedulers());
    }

    @Override
    public Single<AuthResponse> auth(EsiaTokenMarker marker) {
        return Observable.zip(
                esiaApi.getUserInfo(marker.getSbjId()),
                esiaApi.getContactsList(marker.getSbjId())
                        .flatMapIterable(ContactsListResponse::getContactsRefList)
                        .map(s -> s.substring(s.lastIndexOf('/')))
                        .flatMap(cttsId -> esiaApi.getContactById(marker.getSbjId(), cttsId))
                        .toList(),

                esiaApi.getKidById(marker.getSbjId())
                        .flatMapIterable(KidsListResponse::getKidsRefList)
                        .map(s -> s.substring(s.lastIndexOf('/')))
                        .flatMap(kidId -> esiaApi.getKidById(marker.getSbjId(), kidId))
                        .map(childrenMapper::transform)
                        .toList(),
                authResponseZipper::transform
        ).toSingle();

    }
}
