package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

public class RequestWasBrokenTrap {

    @SerializedName("traps")
    private String traps;

    public String getTraps() {
        return traps;
    }

    public void setTraps(String traps) {
        this.traps = traps;
    }

}
