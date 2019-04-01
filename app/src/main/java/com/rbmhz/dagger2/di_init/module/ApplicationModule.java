package com.rbmhz.dagger2.di_init.module;

import android.content.Context;

import com.rbmhz.dagger2.di_init.scope.Scope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {
    private final Context app;

    @Inject
    public ApplicationModule(Context app) {
        this.app = app;
    }

    @Provides
    @Scope
    Context Context() {
        return app;
    }

}
