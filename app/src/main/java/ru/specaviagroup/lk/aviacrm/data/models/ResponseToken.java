package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseToken {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
