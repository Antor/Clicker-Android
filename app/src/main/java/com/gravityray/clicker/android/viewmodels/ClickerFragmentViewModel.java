package com.gravityray.clicker.android.viewmodels;

import com.gravityray.clicker.android.presentationmodels.ClickerFragmentPresentationModel;
import com.gravityray.clicker.domain.interactors.DoClickInteractor;
import com.gravityray.clicker.domain.interactors.GetClickCountInteractor;
import com.gravityray.clicker.domain.interactors.ResetClickCountInteractor;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.disposables.SerialDisposable;
import io.reactivex.schedulers.Schedulers;

public final class ClickerFragmentViewModel extends ViewModel {

    private final GetClickCountInteractor getClickCountInteractor;
    private final DoClickInteractor doClickInteractor;
    private final ResetClickCountInteractor resetClickCountInteractor;

    private final SerialDisposable clickDisposable;
    private final SerialDisposable resetDisposable;

    @Inject
    public ClickerFragmentViewModel(
            GetClickCountInteractor getClickCountInteractor,
            DoClickInteractor doClickInteractor,
            ResetClickCountInteractor resetClickCountInteractor) {
        this.getClickCountInteractor = getClickCountInteractor;
        this.doClickInteractor = doClickInteractor;
        this.resetClickCountInteractor = resetClickCountInteractor;

        clickDisposable = new SerialDisposable();
        resetDisposable = new SerialDisposable();
    }

    @Override
    protected void onCleared() {
        clickDisposable.dispose();
        resetDisposable.dispose();
    }

    public Observable<ClickerFragmentPresentationModel> getPresentationModel() {
        return getClickCountInteractor.get()
                .map(ClickerFragmentPresentationModel::new);
    }

    public void click() {
        clickDisposable.set(
                doClickInteractor
                        .click()
                        .subscribeOn(Schedulers.io())
                        .subscribe());
    }

    public void reset() {
        resetDisposable.set(
                resetClickCountInteractor
                        .reset()
                        .subscribeOn(Schedulers.io())
                        .subscribe());
    }
}
