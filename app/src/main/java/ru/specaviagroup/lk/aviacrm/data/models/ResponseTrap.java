package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

public class ResponseTrap {

    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private ResponseTypeTrap responseTypeTrap;
    @SerializedName("box")
    private ResponseBox responseBox;

    public ResponseBox getResponseBox() {
        return responseBox;
    }

    public void setResponseBox(ResponseBox responseBox) {
        this.responseBox = responseBox;
    }

    public ResponseTypeTrap getResponseTypeTrap() {
        return responseTypeTrap;
    }

    public void setResponseTypeTrap(ResponseTypeTrap responseTypeTrap) {
        this.responseTypeTrap = responseTypeTrap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
