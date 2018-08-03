package com.ibis.ibisecp2.notification;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.ibis.ibisecp2.dagger.HasComponent;
import com.ibis.ibisecp2.dagger.component.AppComponent;
import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import com.ibis.ibisecp2.model.Visit;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;

/**
 * Created by danila on 15.11.16.
 */

public class AlarmSetter extends WakefulBroadcastReceiver {

    private static boolean isRun;

    @Inject
    VisitLoadHelper reminderHelper;
    private Subscription subscription;

    @Override
    // once phone reboot complete, set back all alarms
    public void onReceive(Context context, Intent intent) {
//        if (!isRun) {
//            isRun = true;
        ((HasComponent<AppComponent>) context.getApplicationContext())
                .getComponent().inject(this);

        if (subscription != null) subscription.unsubscribe();
        subscription = reminderHelper.getVisitList()
                .subscribe(new Observer<List<Visit>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Visit> reminders) {
                        setupReminders(reminders, context);
                        subscription.unsubscribe();
                    }
                });
//        }
    }

    private void setupReminders(List<Visit> reminders, Context context) {
        for (Visit reminder : reminders) {
            long time = reminder.getTime();
            if (time > Calendar.getInstance().getTimeInMillis()) {
                Intent service = new Intent(context, AlarmService.class);
                service.setAction(AlarmService.CREATE);
                service.putExtra("id", reminder.get_id());
                context.startService(service);
            }
        }
    }
}
