package com.ibis.ibisecp2.notification;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

import com.ibis.ibisecp2.dagger.HasComponent;
import com.ibis.ibisecp2.dagger.component.AppComponent;
import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import com.ibis.ibisecp2.model.Visit;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;

/**
 * Created by danila on 15.11.16.
 */

public class AlarmService extends IntentService {

    public static final String CREATE = "CREATE";
    public static final String CANCEL = "CANCEL";
    public static final String DELETE = "DELETE";
    @Inject
    VisitLoadHelper visitLoadHelper;
    private IntentFilter matcher;
    private Subscription subscription;

    public AlarmService() {
        super("AlarmService");
        matcher = new IntentFilter();
        matcher.addAction(CREATE);
        matcher.addAction(CANCEL);
        matcher.addAction(DELETE);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ((HasComponent<AppComponent>) getApplicationContext())
                .getComponent().inject(this);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        long id = intent.getLongExtra("id", 0);

        if (matcher.matchAction(action)) {
            execute(action, id);
        }
    }

    private void execute(String action, long id) {

        if (subscription != null) subscription.unsubscribe();
        subscription = visitLoadHelper.getVisit(id).subscribe(new Observer<Visit>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Visit visit) {
                setReminder(id, visit, action);
                subscription.unsubscribe();
            }
        });

    }

    private void setReminder(long id, Visit visit, String action) {
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("id", visit.get_id());

        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(this, (int) (long) id, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT); // visit.get_id()
        long timeInMilliseconds = visit.getTime();

        if (CREATE.equals(action)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarm.setExact(AlarmManager.RTC_WAKEUP, timeInMilliseconds, pendingIntent);
            } else {
                alarm.set(AlarmManager.RTC_WAKEUP, timeInMilliseconds, pendingIntent);
            }
        } else if (DELETE.equals(action)) {
            alarm.cancel(pendingIntent);
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel((int) id);
        }
    }
}
