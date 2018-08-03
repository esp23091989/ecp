package com.ibis.ibisecp2;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;
import com.ibis.ibisecp2.dagger.HasComponent;
import com.ibis.ibisecp2.dagger.component.AppComponent;
import com.ibis.ibisecp2.dagger.component.DaggerAppComponent;
import com.ibis.ibisecp2.dagger.module.AppModule;

import io.fabric.sdk.android.Fabric;

/**
 * Created by danila on 08.11.15.
 */
public class EcpApplication extends Application implements HasComponent<AppComponent> {
    private static EcpApplication instance;
    private AppComponent mAppComponent;

    public static EcpApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initializeInjector();
        Fabric.with(this, new Crashlytics());
        if (BuildConfig.DEBUG) {
            // Create an InitializerBuilder
            Stetho.InitializerBuilder initializerBuilder =
                    Stetho.newInitializerBuilder(this);

            // Enable Chrome DevTools
            initializerBuilder.enableWebKitInspector(
                    Stetho.defaultInspectorModulesProvider(this)
            );

            // Enable command line interface
            initializerBuilder.enableDumpapp(
                    Stetho.defaultDumperPluginsProvider(this)
            );

            // Use the InitializerBuilder to generate an Initializer
            Stetho.Initializer initializer = initializerBuilder.build();

            // Initialize Stetho with the Initializer
            Stetho.initialize(initializer);
        }

    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @Override
    public AppComponent getComponent() {
        return mAppComponent;
    }
}
