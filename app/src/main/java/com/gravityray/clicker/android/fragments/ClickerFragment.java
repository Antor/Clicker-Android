package com.gravityray.clicker.android.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gravityray.clicker.android.R;
import com.gravityray.clicker.android.viewmodels.ClickerFragmentViewModel;


public class ClickerFragment extends Fragment {

    private ClickerFragmentViewModel viewModel;

    public ClickerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clicker, container, false);
    }

}
