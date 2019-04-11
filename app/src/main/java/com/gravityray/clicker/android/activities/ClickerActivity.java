package com.gravityray.clicker.android.activities;

import android.os.Bundle;

import com.gravityray.clicker.android.R;

import dagger.android.support.DaggerAppCompatActivity;

public final class ClickerActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);
    }
}
