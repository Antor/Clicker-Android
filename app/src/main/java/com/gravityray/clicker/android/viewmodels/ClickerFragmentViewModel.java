package com.gravityray.clicker.android.viewmodels;

import com.gravityray.clicker.android.presentationmodels.ClickerFragmentPresentationModel;
import com.gravityray.clicker.domain.interactors.DoClickInteractor;
import com.gravityray.clicker.domain.interactors.GetClickCountInteractor;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.disposables.SerialDisposable;

public final class ClickerFragmentViewModel extends ViewModel {

    private final GetClickCountInteractor getClickCountInteractor;
    private final DoClickInteractor doClickInteractor;

    private final SerialDisposable clickDisposable;

    @Inject
    public ClickerFragmentViewModel(
            GetClickCountInteractor getClickCountInteractor,
            DoClickInteractor doClickInteractor) {
        this.getClickCountInteractor = getClickCountInteractor;
        this.doClickInteractor = doClickInteractor;

        clickDisposable = new SerialDisposable();
    }

    public Observable<ClickerFragmentPresentationModel> getPresentationModel() {
        return getClickCountInteractor.get()
                .map(ClickerFragmentPresentationModel::new);
    }

    public void click() {
        clickDisposable.set(
                doClickInteractor
                        .click()
                        .subscribe());
    }
}
