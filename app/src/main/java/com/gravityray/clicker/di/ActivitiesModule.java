package com.gravityray.clicker.di;

import com.gravityray.clicker.android.activities.ClickerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract ClickerActivity contributeClickerActivityInjector();
}
