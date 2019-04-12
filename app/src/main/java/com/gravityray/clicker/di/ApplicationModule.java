package com.gravityray.clicker.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.gravityray.clicker.android.preferences.ClickSharedPreferencesContract;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Named(ClickSharedPreferencesContract.NAME)
    public SharedPreferences provideClickPreferences() {
        return application.getSharedPreferences(
                ClickSharedPreferencesContract.NAME,
                Context.MODE_PRIVATE);
    }
}
