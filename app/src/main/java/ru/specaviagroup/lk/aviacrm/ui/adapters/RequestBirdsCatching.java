package ru.specaviagroup.lk.aviacrm.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.request.RequestBirdsActive;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseViewHolder;

public class RequestBirdsCatching extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private List<RequestBirdsActive> requestBirdsAdapters = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new RequestBirdsCatching.RequestBirdsCatchingViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_request_birds, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return requestBirdsAdapters.size();
    }

    public void setItems(RequestBirdsActive requestBirdsActive) {
        if (this.requestBirdsAdapters.isEmpty()) {
            this.requestBirdsAdapters.add(requestBirdsActive);
        } else {
            for (RequestBirdsActive items : this.requestBirdsAdapters) {
                if (requestBirdsActive.getId().equals(items.getId())) {
                    this.requestBirdsAdapters.remove(items);
                    break;
                }
            }
            this.requestBirdsAdapters.add(requestBirdsActive);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        this.requestBirdsAdapters.clear();
        notifyDataSetChanged();
    }

    public class RequestBirdsCatchingViewHolder extends BaseViewHolder {

        @BindView(R.id.value_text_view)
        TextView value;

        public RequestBirdsCatchingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBind(int position) {
            value.setText(requestBirdsAdapters.get(position).getId() + "--" + " " + requestBirdsAdapters.get(position).getPests());
        }

    }
}

