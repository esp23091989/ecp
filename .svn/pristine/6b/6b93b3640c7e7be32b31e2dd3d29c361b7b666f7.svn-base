package com.ibis.ibisecp2.presenters;

import rx.Subscription;

/**
 * Created by danila on 03.08.16.
 */
public abstract class BasePresenter<T> {

    public T view;
    protected Subscription subscription;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
        unsubscribedSubscription();
    }

    protected void unsubscribedSubscription() {
        if (subscription != null) subscription.unsubscribe();
    }

    public boolean isViewAttached() {
        return view != null;
    }
}
