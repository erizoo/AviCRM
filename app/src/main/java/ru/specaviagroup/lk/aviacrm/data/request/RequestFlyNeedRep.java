package ru.specaviagroup.lk.aviacrm.data.request;

import com.google.gson.annotations.SerializedName;

public class RequestFlyNeedRep {

    @SerializedName("traps")
    private String traps;
    @SerializedName("comment")
    private String comment;

    public String getTraps() {
        return traps;
    }

    public String getComment() {
        return comment;
    }

    public void setTraps(String traps) {
        this.traps = traps;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
