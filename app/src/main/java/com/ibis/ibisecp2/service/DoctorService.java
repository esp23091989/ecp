package com.ibis.ibisecp2.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.ibis.ibisecp2.dagger.HasComponent;
import com.ibis.ibisecp2.dagger.component.AppComponent;
import com.ibis.ibisecp2.events.UpdateDoctors;
import com.ibis.ibisecp2.events.UpdateDoctorsError;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.DoctorResponse;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;

/**
 * Created by comp on 25.04.17.
 */

public class DoctorService extends IntentService {

    @Inject
    DoctorLoaderHelper mDoctorLoaderHelper;
    @Inject
    SharedPreferencesUtils mPreferences;
    private Subscription mSubscription;
    private List<Doctor> doctorList;

    public DoctorService() {
        super("DoctorService");
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, DoctorService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ((HasComponent<AppComponent>) getApplicationContext())
                .getComponent().inject(this);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (mSubscription != null) mSubscription.unsubscribe();
        mSubscription = mDoctorLoaderHelper.getDoctors(mPreferences.getClinicId())
                .flatMap(new Func1<DoctorResponse, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(DoctorResponse doctorResponse) {
                        doctorList = doctorResponse.getDoctorList();
                        for (int i = 0; i < doctorList.size(); i++) {
                            doctorList.get(i).set_id(Long
                                    .parseLong(doctorList.get(i).getSnils()));
                        }
                        return mDoctorLoaderHelper.deleteDoctors();
                    }
                })
                .flatMap(new Func1<Boolean, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Boolean aBoolean) {
                        return mDoctorLoaderHelper.saveDoctors(doctorList);
                    }
                })
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        EventBus.getDefault().postSticky(new UpdateDoctorsError(e));
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (mSubscription != null) mSubscription.unsubscribe();
                        EventBus.getDefault().postSticky(new UpdateDoctors());
                    }
                });

    }

    @Override
    public void onDestroy() {
        if (mSubscription != null) mSubscription.unsubscribe();
        super.onDestroy();
    }
}
