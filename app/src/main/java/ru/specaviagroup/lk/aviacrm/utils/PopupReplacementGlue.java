package ru.specaviagroup.lk.aviacrm.utils;

import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import ru.specaviagroup.lk.aviacrm.R;

public class PopupReplacementGlue extends PopupWindow {

    public PopupReplacementGlue(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView) {
        setElevation(6.0f);
        setFocusable(true);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();
    }
}