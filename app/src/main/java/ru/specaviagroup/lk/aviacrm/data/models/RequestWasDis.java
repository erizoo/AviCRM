package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.SerializedName;

public class RequestWasDis {

    @SerializedName("box_id")
    private String boxId;
    @SerializedName("pesticide_id")
    private String pesticideId;
    @SerializedName("count")
    private String count;
    @SerializedName("comment")
    private String comment;

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getPesticideId() {
        return pesticideId;
    }

    public void setPesticideId(String pesticideId) {
        this.pesticideId = pesticideId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
