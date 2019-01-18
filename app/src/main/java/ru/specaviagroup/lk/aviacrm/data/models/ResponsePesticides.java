package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePesticides {

    @SerializedName("pesticide")
    @Expose
    private String pesticide;
    @SerializedName("date")
    @Expose
    private String date;

    public String getPesticide() {
        return pesticide;
    }

    public void setPesticide(String pesticide) {
        this.pesticide = pesticide;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
