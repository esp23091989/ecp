package com.ibis.ibisecp2.listeners;

/**
 * Created by danila on 04.12.15.
 */
public interface EnrollHelperListener {
    void onSuccessEnroll();

    void onErrorEnroll(int code);
}
