package com.ibis.ibisecp2.dagger.component;


import com.ibis.ibisecp2.dagger.module.ActivityModule;
import com.ibis.ibisecp2.dagger.module.ApiModule;
import com.ibis.ibisecp2.dagger.module.AppModule;
import com.ibis.ibisecp2.dagger.module.HelperModule;
import com.ibis.ibisecp2.dagger.module.UtilsModule;
import com.ibis.ibisecp2.notification.AlarmReceiver;
import com.ibis.ibisecp2.notification.AlarmService;
import com.ibis.ibisecp2.notification.AlarmSetter;
import com.ibis.ibisecp2.service.DoctorService;
import com.ibis.ibisecp2.service.FavoritesDoctorsService;
import com.ibis.ibisecp2.service.TrackGps;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by danila on 08.11.15.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class,
        HelperModule.class,
        UtilsModule.class
})
public interface AppComponent {

    ActivityComponent plus(ActivityModule activityModule);

    void inject(AlarmService alarmService);

    void inject(AlarmReceiver alarmReceiver);

    void inject(AlarmSetter alarmSetter);

    void inject(TrackGps trackGps);

    void inject(FavoritesDoctorsService favoritesDoctorsService);

    void inject(DoctorService doctorService);
}
