package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

public class ResponseTypeTrap {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
