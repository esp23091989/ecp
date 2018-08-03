package com.ibis.ibisecp2.listeners;

import com.ibis.ibisecp2.model.SvedMu;

/**
 * Created by danila on 29.06.16.
 */
public interface SvedMuLoaderHelperListener {
    void onSvedMuSuccess(SvedMu svedMu);

    void onError(Throwable e);

    void onErrorMsg(String msg, Integer code);
}
