package com.gravityray.clicker.android;

import com.gravityray.clicker.di.ApplicationModule;
import com.gravityray.clicker.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public final class ClickerApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent
                .builder()
                .applicationModule(
                        new ApplicationModule(this))
                .build();
    }
}
