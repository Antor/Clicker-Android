package com.gravityray.clicker.di.fragments;

import com.gravityray.clicker.android.fragments.ClickerFragment;
import com.gravityray.clicker.android.viewmodels.ClickerFragmentViewModel;

import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

@Module
public final class ClickerFragmentModule {

    @Provides
    public ViewModelProvider provideViewModelProvider(
            ClickerFragment fragment,
            Provider<ClickerFragmentViewModel> viewModelProvider) {
        return new ViewModelProvider(
                fragment,
                new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                        return (T) viewModelProvider.get();
                    }
                });
    }
}
