package com.gravityray.clicker.di;

import com.gravityray.clicker.data.InMemoryClickRepository;
import com.gravityray.clicker.domain.ClickRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoriesModule {

    @Binds
    public abstract ClickRepository bindClickRepository(
            InMemoryClickRepository repository);
}
