package com.ibis.ibisecp2.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.ibis.ibisecp2.R;
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

public class AlarmReceiver extends WakefulBroadcastReceiver {

    @Inject
    VisitLoadHelper reminderHelper;
    private Subscription subscription;


    @Override
    public void onReceive(Context context, Intent intent) {
        ((HasComponent<AppComponent>) context.getApplicationContext())
                .getComponent().inject(this);

        long id = intent.getLongExtra("id", 0L);

        if (subscription != null) subscription.unsubscribe();
        subscription = reminderHelper.getVisit(id).subscribe(new Observer<Visit>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Visit reminder) {
                createNotification(reminder, context);
                subscription.unsubscribe();
            }
        });
    }

    private void createNotification(Visit reminder, Context context) {
        final String data = reminder.getStartOn() == null ? "" : reminder.getStartOn();
        final String address = reminder.getAddress() == null ? "" : reminder.getAddress();
        final String doctorName = reminder.getDoctorName() == null ? "" : reminder.getDoctorName();
        final String msg = data + "\n" + address + "\n" + doctorName;
        final String title = context.getString(R.string.title_reception);
        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
        bigStyle.setBigContentTitle(title);
        bigStyle.bigText(msg);
        Notification n = new NotificationCompat.Builder(context)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.mainicon))
                .setSmallIcon(R.drawable.ic_event_white_24dp)
                .setContentTitle(title)
                .setContentText(msg)
                .setWhen(0)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setStyle(bigStyle)
                .setAutoCancel(true)
                .build();

        n.defaults |= Notification.DEFAULT_VIBRATE;
        n.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        n.defaults |= Notification.DEFAULT_SOUND;

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify((int) (long) reminder.get_id(), n);
    }
}
