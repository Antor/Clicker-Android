package com.gravityray.clicker.di;

import com.gravityray.clicker.di.fragments.ClickerFragmentModule;
import com.gravityray.clicker.android.fragments.ClickerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = {
            ClickerFragmentModule.class
    })
    abstract ClickerFragment contributeClickerFragmentInjector();
}
