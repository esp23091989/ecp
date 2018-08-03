package com.ibis.ibisecp2.listeners;

/**
 * Created by danila on 05.08.16.
 */
public interface ResponseHelperListener {
    void onSuccess();

    void onError(Throwable e);

    void onErrorMsg(String msg, Integer code);
}
