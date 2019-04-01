package com.rbmhz.dagger2.helper;

import android.app.Application;
import android.content.Context;

import com.rbmhz.dagger2.di_init.component.ApplicationComponent;
import com.rbmhz.dagger2.di_init.component.DaggerApplicationComponent;
import com.rbmhz.dagger2.di_init.module.ApiModule;

public class App extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependencies();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    private void initializeDependencies() {
        applicationComponent = DaggerApplicationComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }

    public ApplicationComponent getNetComponent() {
        return applicationComponent;
    }

}
