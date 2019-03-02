package ru.specaviagroup.lk.aviacrm.utils;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.ui.adapters.HandBookAdapter;

public class PopupHandBook extends PopupWindow implements HandBookAdapter.Callback{

    private ResponseHandBook handBook;
    private Callback callback;
    private HandBookAdapter handBookAdapter;

    public PopupHandBook(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView, List<ResponseHandBook> responseHandBook, boolean isComments) {
        setElevation(6.0f);
        setFocusable(false);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();

        LinearLayoutManager layoutManager = new LinearLayoutManager(popupView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = popupView.findViewById(R.id.popup_recycler);
        handBookAdapter = new HandBookAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(handBookAdapter);
        handBookAdapter.setItems(responseHandBook);
        handBookAdapter.setCallback(this);
        EditText comments = popupView.findViewById(R.id.comments);
        if (!isComments){
            comments.setVisibility(View.GONE);
        }
        popupView.findViewById(R.id.popup_save_button).setOnClickListener(v -> {
            if (handBook != null){
                callback.savePreparation(handBook);
                dismiss();
            }
        });
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
