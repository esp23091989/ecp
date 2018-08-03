package com.ibis.ibisecp2.service;

import android.app.IntentService;
import android.content.Intent;

import com.ibis.ibisecp2.dagger.HasComponent;
import com.ibis.ibisecp2.dagger.component.AppComponent;
import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import com.ibis.ibisecp2.model.FavoriteDoctor;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;

/**
 * Created by comp on 21.04.17.
 */

public class FavoritesDoctorsService extends IntentService {
    public static final String EXTRA_DOCTOR = "com.ibis.ibisecp2.doctor";

    @Inject
    FavoritesDoctorsHelper mHelper;

    private Subscription subscription;

    public FavoritesDoctorsService() {
        super("FavoritesDoctorsService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ((HasComponent<AppComponent>) getApplicationContext())
                .getComponent().inject(this);
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        FavoriteDoctor favoriteDoctor = (FavoriteDoctor) intent.getParcelableExtra(EXTRA_DOCTOR);
        if (favoriteDoctor != null) {
            favoriteDoctor.set_id(Long.parseLong(favoriteDoctor.getSnils()));
            subscription = mHelper.saveFavoriteDoctor(favoriteDoctor)
                    .subscribe(new Observer<Boolean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(Boolean aBoolean) {
                            boolean a = aBoolean;
                        }
                    });

        }


    }

/*    private void deleteItem(FavoriteDoctor deleteDoctor, FavoriteDoctor saveDoctor) {
        if (subscription != null) subscription.unsubscribe();
        subscription = mHelper.deleteDoctor(deleteDoctor)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        saveItem(saveDoctor);
                    }
                });
    }

    private void saveItem(FavoriteDoctor favoriteDoctor) {
        if (subscription != null) subscription.unsubscribe();
        subscription = mHelper.saveDoctor(favoriteDoctor)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        stopSelf();
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        stopSelf();
                    }
                });
    }*/


    @Override
    public void onDestroy() {
        if (subscription != null) subscription.unsubscribe();
        super.onDestroy();
    }
}
