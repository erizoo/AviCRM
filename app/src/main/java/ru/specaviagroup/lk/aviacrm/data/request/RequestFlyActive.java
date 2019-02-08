package ru.specaviagroup.lk.aviacrm.data.request;

import com.google.gson.annotations.SerializedName;

public class RequestFlyActive {



    @SerializedName("trap_id")
    private String id;
    @SerializedName("pests_counts")
    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
