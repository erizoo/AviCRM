package ru.specaviagroup.lk.aviacrm.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.List;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.data.request.RequestBirdsActive;
import ru.specaviagroup.lk.aviacrm.ui.adapters.HandBookAdapter;

public class PopupFlyControlActive extends PopupWindow implements HandBookAdapter.CallbackFlyControl {

    private RequestBirdsActive requestBirdsActive;
    private CallbackPopupFlyControl callbackPopupFlyControl;

    public PopupFlyControlActive(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView, List<ResponseHandBook> responseHandBooks, boolean b) {
        setElevation(6.0f);
        setFocusable(true);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();
        requestBirdsActive = new RequestBirdsActive();
        LinearLayoutManager layoutManager = new LinearLayoutManager(popupView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = popupView.findViewById(R.id.rv_fly_active);
        HandBookAdapter handBookAdapter = new HandBookAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(handBookAdapter);
        handBookAdapter.setItemsFlyControl(responseHandBooks, true);
        handBookAdapter.setCallbackFlyControl(this);
        EditText seagulls = popupView.findViewById(R.id.seagulls_value);
        EditText sparrows = popupView.findViewById(R.id.sparrows_value);
        EditText crows = popupView.findViewById(R.id.crows_value);
        EditText pigeons = popupView.findViewById(R.id.pigeons_value);
        EditText rooks = popupView.findViewById(R.id.rooks_value);
        EditText swallows = popupView.findViewById(R.id.swallows_value);
        EditText magpies = popupView.findViewById(R.id.magpies_value);
        EditText swifts = popupView.findViewById(R.id.swifts_value);
        popupView.findViewById(R.id.save_popup_button).setOnClickListener(v -> {
            if (seagulls.getText().toString().equals("")) {
                seagulls.setText("0");
            }
            if (sparrows.getText().toString().equals("")) {
                sparrows.setText("0");
            }
            if (crows.getText().toString().equals("")) {
                crows.setText("0");
            }
            if (pigeons.getText().toString().equals("")) {
                pigeons.setText("0");
            }
            if (rooks.getText().toString().equals("")) {
                rooks.setText("0");
            }
            if (swallows.getText().toString().equals("")) {
                swallows.setText("0");
            }
            if (magpies.getText().toString().equals("")) {
                magpies.setText("0");
            }
            if (swifts.getText().toString().equals("")) {
                swifts.setText("0");
            }
            String sb = "19=" + seagulls.getText().toString() + "," + "20=" + sparrows.getText().toString() + "," +
                    "21=" + crows.getText().toString() + "," + "22=" + pigeons.getText().toString() + "," +
                    "23=" + rooks.getText().toString() + "," + "24=" + swallows.getText().toString() + "," +
                    "25=" + magpies.getText().toString() + "," + "26=" + swifts.getText().toString() + ",";
            requestBirdsActive.setPests(sb);
            if (b){
                callbackPopupFlyControl.saveBirdsActive(requestBirdsActive, true);
            } else {
                callbackPopupFlyControl.saveBirdsActive(requestBirdsActive, false);
            }
            dismiss();
        });
        popupView.findViewById(R.id.abort_popup_button).setOnClickListener(v -> {
            dismiss();
        });
    }

    @Override
    public void save(ResponseHandBook responseHandBook) {
        requestBirdsActive.setId(responseHandBook.getId().toString());
    }

    public void setCallback(CallbackPopupFlyControl callbackPopupFlyControl) {
        this.callbackPopupFlyControl = callbackPopupFlyControl;
    }

    public interface CallbackPopupFlyControl {

        void saveBirdsActive(RequestBirdsActive requestBirdsActive, boolean isActive);
    }
}
