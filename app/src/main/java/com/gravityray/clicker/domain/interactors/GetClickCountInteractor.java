package com.gravityray.clicker.domain.interactors;

import com.gravityray.clicker.domain.ClickRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetClickCountInteractor {

    private final ClickRepository clickRepository;

    @Inject
    public GetClickCountInteractor(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    public Observable<Integer> get() {
        return clickRepository.getClickCounter();
    }
}
