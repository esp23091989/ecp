package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.MedicamentFindHelper;
import com.ibis.ibisecp2.model.MedicamentResponse;
import com.ibis.ibisecp2.presenters.MedicamentFindPresenter;
import com.ibis.ibisecp2.ui.view.MedicamentFindView;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by danila on 05.08.16.
 */
public class MedicamentFindPresenterImpl extends MedicamentFindPresenter {

    private MedicamentFindHelper medicamentFindHelper;
    private DialogsHelper helper;

    @Inject
    public MedicamentFindPresenterImpl(DialogsHelper helper,
                                       MedicamentFindHelper medicamentFindHelper) {
        this.helper = helper;
        this.medicamentFindHelper = medicamentFindHelper;
    }

    @Override
    public void attachView(MedicamentFindView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        if (subscription != null) subscription.unsubscribe();
    }

    @Override
    public void findMedicament(String name) {
        if (subscription != null) subscription.unsubscribe();
        subscription = medicamentFindHelper.findMedicament(name)
                .subscribe(new Observer<MedicamentResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.error();
                            helper.alertDialogError(e);
                        }
                    }

                    @Override
                    public void onNext(MedicamentResponse response) {
                        if (isViewAttached()) {
                            view.showMedicament(response.getMedicamentList());
                        }
                    }
                });
    }
}
