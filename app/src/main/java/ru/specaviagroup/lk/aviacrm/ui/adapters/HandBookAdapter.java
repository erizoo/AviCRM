package ru.specaviagroup.lk.aviacrm.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseViewHolder;

public class HandBookAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private List<ResponseHandBook> responseHandBook = new ArrayList<>();
    private Callback callback;
    private CallbackFlyControl callbackFlyControl;
    private boolean isFlyControlActive = false;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new HandBookAdapter.HandBookViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_hand_book, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return responseHandBook.size();
    }

    public void setItems(List<ResponseHandBook> responseHandBook) {
        this.responseHandBook.clear();
        this.responseHandBook.addAll(responseHandBook);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void setCallbackFlyControl(CallbackFlyControl callbackFlyControl) {
        this.callbackFlyControl = callbackFlyControl;
    }

    public void setItemsFlyControl(List<ResponseHandBook> responseHandBooks, boolean isFlyControlActive) {
        this.responseHandBook.clear();
        this.isFlyControlActive = isFlyControlActive;
        this.responseHandBook.addAll(responseHandBooks);
    }

    public interface Callback {

        void save(ResponseHandBook responseHandBook);

    }

    public interface CallbackFlyControl {

        void save(ResponseHandBook responseHandBook);

    }

    public class HandBookViewHolder extends BaseViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.checkbox)
        CheckBox checkBox;


        public HandBookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @Override
        public void onBind(int position) {
            title.setText(responseHandBook.get(position).getPoint());
            if (!isFlyControlActive) {
                checkBox.setOnClickListener(v -> {
                    callback.save(responseHandBook.get(position));
                });
            }
            if (isFlyControlActive) {
                checkBox.setOnClickListener(v -> {
                    callbackFlyControl.save(responseHandBook.get(position));
                });
            }
        }

    }

}
