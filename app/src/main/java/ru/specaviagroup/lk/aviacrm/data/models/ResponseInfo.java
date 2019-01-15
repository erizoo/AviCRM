package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

public class ResponseInfo {

    @SerializedName("access_token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
