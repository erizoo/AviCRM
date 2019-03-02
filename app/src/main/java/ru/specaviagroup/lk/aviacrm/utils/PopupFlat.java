package ru.specaviagroup.lk.aviacrm.utils;

import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;

public class PopupFlat extends PopupWindow {

    private Callback callback;

    public PopupFlat(View contentView, int width, int height) {
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
        EditText tarakanValue = popupView.findViewById(R.id.tarakan_value);
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
            if (tarakanValue.getText().toString().equals("")) {
                tarakanValue.setText("0");
            }
            RequestFlyActive requestFlyActive = new RequestFlyActive();
            String sb = "1=" + midges.getText().toString() + "," + "2=" + flies.getText().toString() + "," +
                    "7=" + goldEyed.getText().toString() + "," + "3=" + mosquitoes.getText().toString() + "," +
                    "9=" + waspsValue.getText().toString() + "," + "12=" + foodMothValue.getText().toString() + ","
                    + "14=" + tarakanValue.getText().toString() + ",";
            requestFlyActive.setAmount(sb);
            requestFlyActive.setId("1");
            callback.saveFly(sb);
            dismiss();

        });
        popupView.findViewById(R.id.abort_popup_button).setOnClickListener(v -> {
            dismiss();
            callback.abort();
        });
    }

    public void setCallback(Callback callback){
        this.callback = callback;
    }

    public interface Callback {

        void saveFly(String requestFlyActive);

        void abort();

    }
}
