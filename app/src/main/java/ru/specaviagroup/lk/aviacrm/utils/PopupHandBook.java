package ru.specaviagroup.lk.aviacrm.utils;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.List;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;
import ru.specaviagroup.lk.aviacrm.ui.adapters.FacilityAdapter;
import ru.specaviagroup.lk.aviacrm.ui.adapters.HandBookAdapter;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileActivity;

public class PopupHandBook extends PopupWindow implements HandBookAdapter.Callback{

    private ResponseHandBook handBook;
    private Callback callback;

    public PopupHandBook(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView, List<ResponseHandBook> responseHandBook) {
        setElevation(6.0f);
        setFocusable(false);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();

        LinearLayoutManager layoutManager = new LinearLayoutManager(popupView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = popupView.findViewById(R.id.popup_recycler);
        HandBookAdapter handBookAdapter = new HandBookAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(handBookAdapter);
        handBookAdapter.setItems(responseHandBook);
        handBookAdapter.setCallback(this);
        popupView.findViewById(R.id.popup_save_button).setOnClickListener(v -> {
            callback.savePreparation(handBook);
            dismiss();
        });
//        popupView.findViewById(R.id.abort_popup_button).setOnClickListener(v -> {
//            dismiss();
//        });
    }

    @Override
    public void save(ResponseHandBook responseHandBook) {
        this.handBook = responseHandBook;
    }

    public interface Callback{

        void savePreparation(ResponseHandBook responseHandBook);

    }

    public void setCallback(Callback callback){
        this.callback = callback;
    }
}
