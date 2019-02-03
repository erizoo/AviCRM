package ru.specaviagroup.lk.aviacrm.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import java.util.List;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.ui.adapters.HandBookAdapter;
import ru.specaviagroup.lk.aviacrm.ui.adapters.RequestBirdsCatching;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileActivity;

public class PopupFlyControlTrap extends PopupWindow {
    
    private RequestBirdsCatching requestBirdsCatching;

    public PopupFlyControlTrap(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView, List<ResponseHandBook> responseHandBooks) {
        setElevation(6.0f);
        setFocusable(true);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();
        requestBirdsCatching = new RequestBirdsCatching();
        LinearLayoutManager layoutManager = new LinearLayoutManager(popupView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = popupView.findViewById(R.id.rv_fly_active);
        HandBookAdapter handBookAdapter = new HandBookAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(handBookAdapter);
     
    }

    public void setCallback(ProfileActivity profileActivity) {
    }
}
