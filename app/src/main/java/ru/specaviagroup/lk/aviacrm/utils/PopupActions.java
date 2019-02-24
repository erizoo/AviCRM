package ru.specaviagroup.lk.aviacrm.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.ui.adapters.HandBookAdapter;
import ru.specaviagroup.lk.aviacrm.ui.adapters.HandBookAdapterActions;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileActivity;

public class PopupActions extends PopupWindow implements HandBookAdapterActions.Callback{

    private HandBookAdapterActions handBookAdapterActions;
    private Callback callback;
    private List<ResponseHandBook> actions = new ArrayList<>();

    public PopupActions(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView, List<ResponseHandBook> responseHandBook, String type) {
        setElevation(6.0f);
        setFocusable(false);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(popupView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = popupView.findViewById(R.id.popup_recycler);
        handBookAdapterActions = new HandBookAdapterActions();
        handBookAdapterActions.setCallback(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(handBookAdapterActions);
        handBookAdapterActions.setItems(responseHandBook);
        if (type.equals("PREVENTIVE_ACTIONS")){
            EditText comments = popupView.findViewById(R.id.comments);
            comments.setVisibility(View.GONE);
        }
        popupView.findViewById(R.id.popup_save_button).setOnClickListener(v -> {
            callback.saveActions(actions);
            dismiss();
            actions.clear();
        });
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void saveActions(ResponseHandBook responseHandBook) {
        actions.add(responseHandBook);
    }

    public interface Callback {

        void saveActions(List<ResponseHandBook> responseHandBooks);

    }

}
