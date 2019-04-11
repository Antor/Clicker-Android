package com.gravityray.clicker.domain.interactors;

import com.gravityray.clicker.domain.ClickRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public final class DoClickInteractor {

    private final ClickRepository clickRepository;

    @Inject
    public DoClickInteractor(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    public Completable click() {
        return clickRepository.incrementClickCounter();
    }
}
