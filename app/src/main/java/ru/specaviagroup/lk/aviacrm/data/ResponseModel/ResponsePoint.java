package ru.specaviagroup.lk.aviacrm.data.ResponseModel;

import com.google.gson.annotations.SerializedName;

public class ResponsePoint {

    @SerializedName("id")
    private int id;
    @SerializedName("point")
    private String point;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}

