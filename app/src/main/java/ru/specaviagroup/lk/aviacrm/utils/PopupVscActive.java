package ru.specaviagroup.lk.aviacrm.utils;

import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileActivity;

public class PopupVscActive extends PopupWindow {

    private Callback callback;

    public PopupVscActive(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView) {
        setElevation(6.0f);
        setFocusable(false);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();
        EditText smallMealworm = popupView.findViewById(R.id.small_mealworm_value);
        EditText surinameMucoed = popupView.findViewById(R.id.suriname_mucoed_value);
        EditText foodMoth = popupView.findViewById(R.id.food_moth_value);
        popupView.findViewById(R.id.save_popup_button).setOnClickListener(v -> {
            if (smallMealworm.getText().toString().equals("")) {
                smallMealworm.setText("0");
            }
            if (surinameMucoed.getText().toString().equals("")) {
                surinameMucoed.setText("0");
            }
            if (foodMoth.getText().toString().equals("")) {
                foodMoth.setText("0");
            }
            RequestFlyActive requestFlyActive = new RequestFlyActive();
            String sb = "8=" + smallMealworm.getText().toString() + "," + "13=" + surinameMucoed.getText().toString() + "," +
                    "18=" + foodMoth.getText().toString() + ",";
            requestFlyActive.setAmount(sb);
            requestFlyActive.setId("1");
            callback.saveVscActive(sb);
            dismiss();

        });
        popupView.findViewById(R.id.abort_popup_button).setOnClickListener(v -> {
            dismiss();
        });
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {

        void saveVscActive(String requestFlyActive);

    }

}
