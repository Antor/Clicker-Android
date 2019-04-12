package com.gravityray.clicker.data;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import com.gravityray.clicker.android.preferences.ClickSharedPreferencesContract;
import com.gravityray.clicker.domain.ClickRepository;
import com.gravityray.rxsharedpreferences.RxSharedPreferences;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Singleton
public final class SharedPreferencesClickRepository implements ClickRepository {

    private static final int DEFAULT_COUNT = 0;

    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesClickRepository(
            @Named(ClickSharedPreferencesContract.NAME)
                    SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Observable<Integer> getClickCounter() {
        return RxSharedPreferences.getIntValue(
                sharedPreferences,
                ClickSharedPreferencesContract.KEY_CLICK_COUNT,
                DEFAULT_COUNT);
    }

    @Override
    public Completable incrementClickCounter() {
        return Completable.fromAction(this::incrementAndPublish);
    }

    @SuppressLint("ApplySharedPref")
    private synchronized void incrementAndPublish() {
        int count = sharedPreferences.getInt(
                ClickSharedPreferencesContract.KEY_CLICK_COUNT,
                DEFAULT_COUNT);
        count++;
        sharedPreferences.edit()
                .putInt(
                        ClickSharedPreferencesContract.KEY_CLICK_COUNT,
                        count)
                .commit();
    }

    @Override
    public Completable resetClickCount() {
        return Completable.fromAction(this::resetAndPublish);
    }

    @SuppressLint("ApplySharedPref")
    private synchronized void resetAndPublish() {
        sharedPreferences.edit()
                .putInt(
                        ClickSharedPreferencesContract.KEY_CLICK_COUNT,
                        DEFAULT_COUNT)
                .commit();
    }
}
