package com.gravityray.clicker.data;

import com.gravityray.clicker.domain.ClickRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

@Singleton
public final class InMemoryClickRepository implements ClickRepository {

    private final int DEFAULT_COUNT = 0;

    private volatile int count;
    private final Subject<Integer> countSubject;

    @Inject
    public InMemoryClickRepository() {
        this.count = DEFAULT_COUNT;
        this.countSubject = BehaviorSubject.createDefault(count)
                .toSerialized();
    }

    @Override
    public Observable<Integer> getClickCounter() {
        return countSubject;
    }

    @Override
    public Completable incrementClickCounter() {
        return Completable.fromAction(this::incrementAndPublish);
    }

    private synchronized void incrementAndPublish() {
        count++;
        countSubject.onNext(count);
    }

    @Override
    public Completable resetClickCount() {
        return Completable.fromAction(this::resetAndPublish);
    }

    private synchronized void resetAndPublish() {
        count = DEFAULT_COUNT;
        countSubject.onNext(count);
    }
}
