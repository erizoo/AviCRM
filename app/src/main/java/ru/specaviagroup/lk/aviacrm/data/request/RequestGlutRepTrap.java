package ru.specaviagroup.lk.aviacrm.data.request;

import com.google.gson.annotations.SerializedName;

public class RequestGlutRepTrap {

    @SerializedName("traps")
    private String traps;
    @SerializedName("pesticide_id")
    private String pesticideId;

    public String getPesticideId() {
        return pesticideId;
    }

    public String getTraps() {
        return traps;
    }

    public void setPesticideId(String pesticideId) {
        this.pesticideId = pesticideId;
    }

    public void setTraps(String traps) {
        this.traps = traps;
    }
}
