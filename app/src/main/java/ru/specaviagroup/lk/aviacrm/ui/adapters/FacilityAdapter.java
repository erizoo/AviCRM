package ru.specaviagroup.lk.aviacrm.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseViewHolder;

public class FacilityAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Callback callback;
    private Context context;
    private List<ResponseFacility> responseFacilities = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new FacilityAdapter.FacilityViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_facility, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return responseFacilities.size();
    }

    public void setItems(List<ResponseFacility> responseFacilities) {
        this.responseFacilities.clear();
        this.responseFacilities.addAll(responseFacilities);
        notifyDataSetChanged();
    }

    public interface Callback{

        void openQrScanner(Integer objectId);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public class FacilityViewHolder extends BaseViewHolder {

        @BindView(R.id.layout)
        LinearLayout layout;
        @BindView(R.id.name_manufacturer)
        TextView nameManufacturer;
        @BindView(R.id.address)
        TextView address;
        @BindView(R.id.number_phone)
        TextView numberPhone;

        public FacilityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBind(int position) {
            try {
                nameManufacturer.setText(responseFacilities.get(position).getObjectFacility().getObjectName());
            } catch (NullPointerException e){
                nameManufacturer.setText("-");
            }
            try {
                address.setText(responseFacilities.get(position).getObjectFacility().getAdress());
            } catch (NullPointerException e){
                address.setText("-");
            }
            try {
                numberPhone.setText(responseFacilities.get(position).getObjectFacility().getTelephone());
            } catch (NullPointerException e){
                numberPhone.setText("-");
            }
            layout.setOnClickListener(v -> {
                callback.openQrScanner(responseFacilities.get(position).getObjectId());
            });
        }
    }
}
