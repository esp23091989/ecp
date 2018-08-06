package com.ibis.ibisecp2.utils;

import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by danila on 28.07.16.
 */
public class RxUtil {
    public <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable<T> observable) -> {
            return observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        };
    }

    public <T> Single.Transformer<T,T> schedulers(){
        return (Single<T> single) -> single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
