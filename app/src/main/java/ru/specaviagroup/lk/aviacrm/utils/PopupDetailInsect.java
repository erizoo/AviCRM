package ru.specaviagroup.lk.aviacrm.utils;

import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;

public class PopupDetailInsect extends PopupWindow {

    private Callback callback;

    public PopupDetailInsect(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView) {
        setElevation(6.0f);
        setFocusable(true);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();
        EditText midges = popupView.findViewById(R.id.midges_value);
        EditText flies = popupView.findViewById(R.id.flies_value);
        EditText goldEyed = popupView.findViewById(R.id.gold_eyed_value);
        EditText mosquitoes = popupView.findViewById(R.id.mosquitoes_value);
        EditText waspsValue = popupView.findViewById(R.id.wasps_value);
        EditText foodMothValue = popupView.findViewById(R.id.food_moth_value);
        popupView.findViewById(R.id.save_popup_button).setOnClickListener(v -> {
            if (midges.getText().toString().equals("")) {
                midges.setText("0");
            }
            if (flies.getText().toString().equals("")) {
                flies.setText("0");
            }
            if (goldEyed.getText().toString().equals("")) {
                goldEyed.setText("0");
            }
            if (mosquitoes.getText().toString().equals("")) {
                mosquitoes.setText("0");
            }
            if (waspsValue.getText().toString().equals("")) {
                waspsValue.setText("0");
            }
            if (foodMothValue.getText().toString().equals("")) {
                foodMothValue.setText("0");
            }
            RequestFlyActive requestFlyActive = new RequestFlyActive();
            String sb = "10=" + midges.getText().toString() + "," + "11=" + flies.getText().toString() + "," +
                    "15=" + goldEyed.getText().toString() + "," + "16=" + mosquitoes.getText().toString() + "," +
                    "17=" + waspsValue.getText().toString() + "," + "18=" + foodMothValue.getText().toString() + ",";
            requestFlyActive.setAmount(sb);
            requestFlyActive.setId("1");
            callback.saveFlyActive(sb);
            dismiss();

        });
        popupView.findViewById(R.id.abort_popup_button).setOnClickListener(v -> {
            dismiss();
            callback.abort();
        });
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {

        void saveFlyActive(String requestFlyActive);

        void abort();

    }
}
