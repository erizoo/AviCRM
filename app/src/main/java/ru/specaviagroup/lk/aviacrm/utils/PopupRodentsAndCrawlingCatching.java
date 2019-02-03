package ru.specaviagroup.lk.aviacrm.utils;

import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileActivity;

public class PopupRodentsAndCrawlingCatching extends PopupWindow {

    public PopupRodentsAndCrawlingCatching(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView) {
        setElevation(6.0f);
        setFocusable(false);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();

    }

    public void setCallback(ProfileActivity profileActivity) {
    }
}
