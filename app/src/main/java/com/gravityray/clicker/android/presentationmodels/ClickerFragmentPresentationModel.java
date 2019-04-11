package com.gravityray.clicker.android.presentationmodels;

public final class ClickerFragmentPresentationModel {

    private final int clickCount;

    public ClickerFragmentPresentationModel(
            final int clickCount) {
        this.clickCount = clickCount;
    }

    public int getClickCount() {
        return clickCount;
    }
}
