package com.ibis.ibisecp2.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.LocationManager;

import com.ibis.ibisecp2.EcpApplication;
import com.ibis.ibisecp2.retrofit.Repository;
import com.ibis.ibisecp2.retrofit.RestRepository;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danila on 08.11.15.
 */
@Module
public class AppModule {
    private final EcpApplication ecpApplication;

    public AppModule(EcpApplication ecpApplication) {
        this.ecpApplication = ecpApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return ecpApplication;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return ecpApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    public Resources provideResource() {
        return ecpApplication.getResources();
    }


    @Provides
    @Singleton
    Repository provideDataRepository(RestRepository repository) {
        return repository;
    }

    @Provides
    @Singleton
    Storage provideDb() {
        return Storage.get();
    }

    @Provides
    @Singleton
    SharedPreferencesUtils provideSharedPreferencesUtils(SharedPreferences prefs) {
        return new SharedPreferencesUtils(prefs);
    }

    @Provides
    public LocationManager provideLocationManager() {
        return (LocationManager) ecpApplication.getSystemService(Context.LOCATION_SERVICE);
    }
}
