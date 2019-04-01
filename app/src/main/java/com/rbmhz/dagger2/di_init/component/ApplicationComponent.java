package com.rbmhz.dagger2.di_init.component;

import com.rbmhz.dagger2.di_init.module.ApplicationModule;
import com.rbmhz.dagger2.views.MainActivity;
import com.rbmhz.dagger2.di_init.module.ApiModule;
import com.rbmhz.dagger2.di_init.scope.Scope;

import dagger.Component;

@Scope
@Component(modules = {
        ApplicationModule.class,
        ApiModule.class  //Adding api module services and provide other classes
})

public interface ApplicationComponent {
    void inject(MainActivity activity); //inject to mainActivity
}
