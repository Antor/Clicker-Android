package com.gravityray.clicker.di;

import com.gravityray.clicker.data.SharedPreferencesClickRepository;
import com.gravityray.clicker.domain.ClickRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoriesModule {

    @Binds
    public abstract ClickRepository bindClickRepository(
            SharedPreferencesClickRepository repository);
}
