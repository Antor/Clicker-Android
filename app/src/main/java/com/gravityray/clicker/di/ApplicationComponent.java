package com.gravityray.clicker.di;

import com.gravityray.clicker.android.ClickerApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,

                ActivitiesModule.class,
                FragmentsModule.class,

                RepositoriesModule.class
        }
)
public interface ApplicationComponent extends AndroidInjector<ClickerApplication> {
}
