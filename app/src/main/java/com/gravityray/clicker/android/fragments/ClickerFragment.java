package com.gravityray.clicker.android.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gravityray.clicker.android.R;
import com.gravityray.clicker.android.presentationmodels.ClickerFragmentPresentationModel;
import com.gravityray.clicker.android.viewmodels.ClickerFragmentViewModel;
import com.jakewharton.rxbinding3.view.RxView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.DaggerFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public final class ClickerFragment extends DaggerFragment {

    private TextView counterTextView;
    private Button clickButton;
    private Button resetButton;

    @Inject
    ViewModelProvider viewModelProvider;

    private ClickerFragmentViewModel viewModel;

    private final CompositeDisposable resumedCompositeDisposable;

    public ClickerFragment() {
        resumedCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = viewModelProvider.get(ClickerFragmentViewModel.class);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clicker, container, false);

        counterTextView = view.findViewById(R.id.counter_text_view);
        clickButton = view.findViewById(R.id.click_button);
        resetButton = view.findViewById(R.id.reset_button);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        resumedCompositeDisposable.addAll(
                viewModel.getPresentationModel()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::showPresentationModel),
                RxView.clicks(clickButton)
                        .subscribe(u -> viewModel.click()),
                RxView.clicks(resetButton)
                        .subscribe(u -> viewModel.reset()));
    }

    @Override
    public void onPause() {
        super.onPause();
        resumedCompositeDisposable.clear();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        counterTextView = null;
        clickButton = null;
        resetButton = null;
    }

    @SuppressLint("SetTextI18n")
    private void showPresentationModel(
            ClickerFragmentPresentationModel presentationModel) {
        int count = presentationModel.getClickCount();
        counterTextView.setText(Integer.toString(count));
    }
}
