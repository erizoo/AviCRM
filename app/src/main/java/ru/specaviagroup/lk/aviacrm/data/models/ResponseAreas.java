package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

public class ResponseAreas {

    @SerializedName("plots")
    private ResponsePlots responsePlots;

    public ResponsePlots getResponsePlots() {
        return responsePlots;
    }

    public void setResponsePlots(ResponsePlots responsePlots) {
        this.responsePlots = responsePlots;
    }
}
