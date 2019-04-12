package com.gravityray.clicker.domain.interactors;

import com.gravityray.clicker.domain.ClickRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public final class ResetClickCountInteractor {

    private final ClickRepository clickRepository;

    @Inject
    public ResetClickCountInteractor(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    public Completable reset() {
        return clickRepository.resetClickCount();
    }
}
