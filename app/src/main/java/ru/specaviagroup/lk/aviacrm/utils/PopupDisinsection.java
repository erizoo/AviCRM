package ru.specaviagroup.lk.aviacrm.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileActivity;

public class PopupDisinsection extends PopupWindow {

    public PopupDisinsection(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView, ProfileActivity profileActivity) {
        setElevation(6.0f);
        setFocusable(true);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();

        Spinner spinnerArea = popupView.findViewById(R.id.spinner_area);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(profileActivity, R.array.animals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArea.setAdapter(adapter);

    }

}
