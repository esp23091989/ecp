package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DiaryRecordsLoaderHelper;
import com.ibis.ibisecp2.helpers.TasksHelper;
import com.ibis.ibisecp2.model.DiaryRecord;
import com.ibis.ibisecp2.model.DiaryRecordsResponse;
import com.ibis.ibisecp2.model.Task;
import com.ibis.ibisecp2.model.Tasks;
import com.ibis.ibisecp2.presenters.DiaryRecordPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment;
import com.ibis.ibisecp2.ui.view.DiaryRecordView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by danila on 08.08.16.
 */
public class DiaryRecordPresenterImpl extends DiaryRecordPresenter {

    private DiaryRecordsLoaderHelper loaderHelper;
    private DialogsHelper dialogsHelper;
    private Navigator navigator;
    private TasksHelper tasksHelper;
    private List<DiaryRecord> diaryRecordList = new ArrayList<DiaryRecord>();

    private List<Task> tasksList;

    @Inject
    public DiaryRecordPresenterImpl(DiaryRecordsLoaderHelper loaderHelper,
                                    DialogsHelper dialogsHelper, Navigator navigator,
                                    TasksHelper tasksHelper) {
        this.loaderHelper = loaderHelper;
        this.dialogsHelper = dialogsHelper;
        this.navigator = navigator;
        this.tasksHelper = tasksHelper;
    }

    @Override
    public void attachView(DiaryRecordView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        if (subscription != null) subscription.unsubscribe();
    }

    @Override
    public void getDiaryRecords(String period) {
        if (subscription != null) subscription.unsubscribe();
        subscription = loaderHelper.getDiaryRecords(period)
                .flatMap(new Func1<DiaryRecordsResponse, Observable<Tasks>>() {
                    @Override
                    public Observable<Tasks> call(DiaryRecordsResponse diaryRecordsResponse) {
                        if (period.equals("0")) {
                            diaryRecordList.clear();
                        }
                        if (diaryRecordList.size() > 0) {
                            diaryRecordList.remove(diaryRecordList.size() - 1);
                        }
                        if (diaryRecordsResponse.getDiaryRecordList() != null) {
                            diaryRecordList.addAll(diaryRecordsResponse.getDiaryRecordList());
                        }
                        if (tasksList != null && tasksList.size() > 0) {
                            view.showDiaryRecords(diaryRecordList, tasksList, diaryRecordsResponse.getDiaryRecordList() != null);
                            subscription.unsubscribe();
                            return null;
                        }
                        return tasksHelper.getTasks();
                    }
                })
                .subscribe(new Observer<Tasks>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.showError();
                        }
                    }

                    @Override
                    public void onNext(Tasks response) {
                        if (isViewAttached()) {
                            if (diaryRecordList != null) {
                                tasksList = response.getItems();
                                view.showDiaryRecords(diaryRecordList, tasksList, true);
                            }
                        }
                    }
                });
    }

    @Override
    public void openTasksScreen(DiaryRecordsFragment recordsFragment) {
        navigator.openTasksScreen(tasksList, recordsFragment);
    }
}
