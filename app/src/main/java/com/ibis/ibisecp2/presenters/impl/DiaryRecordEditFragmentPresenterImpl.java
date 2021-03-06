package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.ChangeDiaryHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.model.ErrorResponse;
import com.ibis.ibisecp2.presenters.DiaryRecordEditFragmentPresenter;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by comp on 07.04.17.
 */

public class DiaryRecordEditFragmentPresenterImpl extends DiaryRecordEditFragmentPresenter {
    private ChangeDiaryHelper changeDiaryHelper;
    private DialogsHelper dialogsHelper;

    @Inject
    public DiaryRecordEditFragmentPresenterImpl(ChangeDiaryHelper changeDiaryHelper,
                                                DialogsHelper dialogsHelper) {
        this.changeDiaryHelper = changeDiaryHelper;
        this.dialogsHelper = dialogsHelper;
    }

    @Override
    public void saveDiary(String note, String date) {
        if (subscription != null) subscription.unsubscribe();
        subscription =
                changeDiaryHelper.changeDiary(note, date)
                        .subscribe(new Observer<ErrorResponse>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                if (isViewAttached()) {
                                    view.showError();
                                    dialogsHelper.alertDialogError(e);
                                }
                            }

                            @Override
                            public void onNext(ErrorResponse response) {
                                if (isViewAttached()) {
                                    view.successEdit(response.getError().getErrorText());
                                }
                            }
                        });
    }
}
