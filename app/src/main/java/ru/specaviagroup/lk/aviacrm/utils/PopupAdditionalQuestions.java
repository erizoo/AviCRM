package ru.specaviagroup.lk.aviacrm.utils;

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
import ru.specaviagroup.lk.aviacrm.ui.adapters.AdditionalQuestionsAdapter;

public class PopupAdditionalQuestions extends PopupWindow implements AdditionalQuestionsAdapter.Callback{

    private AdditionalQuestionsAdapter additionalQuestionsAdapter;
    private Callback callback;
    private List<ResponseHandBook> actions = new ArrayList<>();

    public PopupAdditionalQuestions(View contentView, int width, int height) {
        super(contentView, width, height);
    }

    public void setUp(View contentView, List<ResponseHandBook> responseHandBooks, String type) {
        setElevation(6.0f);
        setFocusable(true);
        setOutsideTouchable(false);
        showAtLocation(contentView, Gravity.CENTER, 0, 0);
        View popupView = getContentView();

        LinearLayoutManager layoutManager = new LinearLayoutManager(popupView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = popupView.findViewById(R.id.popup_recycler);
        additionalQuestionsAdapter = new AdditionalQuestionsAdapter();
        additionalQuestionsAdapter.setCallback(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(additionalQuestionsAdapter);
        additionalQuestionsAdapter.setItems(responseHandBooks);
        EditText editText = popupView.findViewById(R.id.comments);
        popupView.findViewById(R.id.popup_save_button).setOnClickListener(v -> {
            callback.saveAdditionalQuestions(actions, type, editText.getText().toString());
            dismiss();
            actions.clear();
        });
    }

    @Override
    public void saveActions(ResponseHandBook responseHandBook) {
        actions.add(responseHandBook);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {

        void saveAdditionalQuestions(List<ResponseHandBook> responseHandBooks, String type, String comments);

    }
}
