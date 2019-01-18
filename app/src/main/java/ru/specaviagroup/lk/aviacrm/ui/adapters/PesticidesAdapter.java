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
import ru.specaviagroup.lk.aviacrm.data.models.ResponsePesticides;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseViewHolder;

public class PesticidesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private List<ResponsePesticides> responsePesticides = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new PesticidesAdapter.PesticidesViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_change_adapter, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return responsePesticides.isEmpty() ? 0 : responsePesticides.size();
    }

    public void setItems(List<ResponsePesticides> responsePesticides) {
        this.responsePesticides.clear();
        this.responsePesticides.addAll(responsePesticides);
        notifyDataSetChanged();
    }


    public class PesticidesViewHolder extends BaseViewHolder {

        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.name)
        TextView name;

        public PesticidesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBind(int position) {
            date.setText(responsePesticides.get(position).getDate());
            name.setText(responsePesticides.get(position).getPesticide());
        }
    }
}