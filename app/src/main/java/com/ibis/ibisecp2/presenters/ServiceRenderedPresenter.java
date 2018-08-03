package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.ServiceRenderedView;

/**
 * Created by danila on 08.08.16.
 */
public abstract class ServiceRenderedPresenter extends BasePresenter<ServiceRenderedView> {
    public abstract void getServiceRendered(String fromDate, String toDate);
}
