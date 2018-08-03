package com.ibis.ibisecp2.listeners;

import java.util.List;

/**
 * Created by danila on 29.12.15.
 */
public interface LoaderHelperListener {
    <T> void loadSuccess(List<T> arrayList);

    void loadError(Throwable e);

    void loadErrorMsg(String msg);
}
