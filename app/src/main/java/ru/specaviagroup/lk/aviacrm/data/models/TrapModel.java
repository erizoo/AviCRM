package ru.specaviagroup.lk.aviacrm.data.models;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrapModel {

    @SerializedName("name")
    @Expose
    private Double name;

    public Double getName() {
        return name;
    }

    public void setName(Double name) {
        this.name = name;
    }
}
