package ru.specaviagroup.lk.aviacrm.data.request;

import com.google.gson.annotations.SerializedName;

public class RequestBirdsActive {

    @SerializedName("box_id")
    private String id;
    @SerializedName("pests_counts")
    private String pests;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPests() {
        return pests;
    }

    public void setPests(String pests) {
        this.pests = pests;
    }
}
