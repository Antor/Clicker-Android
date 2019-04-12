package com.gravityray.clicker.domain;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface ClickRepository {

    Observable<Integer> getClickCounter();

    Completable incrementClickCounter();

    Completable resetClickCount();
}
