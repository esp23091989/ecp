package com.ibis.ibisecp2.dagger.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ibis.ibisecp2.utils.DistanceUtil;
import com.ibis.ibisecp2.utils.DistanceUtilImpl;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danila on 28.07.16.
 */
@Module(includes = {AppModule.class})
public class UtilsModule {
    @Provides
    @Singleton
    public RxUtil provideRxUtil() {
        return new RxUtil();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @Singleton
    public EncryptUtils provideEncryptUtils(SharedPreferencesUtils sharedPreferencesUtils) {
        return new EncryptUtils(sharedPreferencesUtils);
    }

    @Provides
    @Singleton
    public DistanceUtil provideDistanceUtil() {
        return new DistanceUtilImpl();
    }


}
