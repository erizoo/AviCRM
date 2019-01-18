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
import ru.specaviagroup.lk.aviacrm.data.models.ResponseRevizor;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseViewHolder;

public class CheckAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private List<ResponseRevizor> responseRevizors = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new CheckAdapter.CheckViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_check_adapter, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return responseRevizors.isEmpty() ? 0 : responseRevizors.size();
    }

    public void setItems(List<ResponseRevizor> responseRevizors) {
        this.responseRevizors.clear();
        this.responseRevizors.addAll(responseRevizors);
        notifyDataSetChanged();
    }

    public class CheckViewHolder extends BaseViewHolder {

        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.activ)
        TextView activ;

        public CheckViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBind(int position) {
            date.setText(responseRevizors.get(position).getReportDate());
            activ.setText(responseRevizors.get(position).getStatus());
        }
    }
}
