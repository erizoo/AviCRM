package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseFacility {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("revizor_id")
    @Expose
    private Integer revizorId;
    @SerializedName("object_id")
    @Expose
    private Integer objectId;
    @SerializedName("object")
    @Expose
    private ResponseObjectFacility objectFacility;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRevizorId() {
        return revizorId;
    }

    public void setRevizorId(Integer revizorId) {
        this.revizorId = revizorId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public ResponseObjectFacility getObjectFacility() {
        return objectFacility;
    }

    public void setObjectFacility(ResponseObjectFacility objectFacility) {
        this.objectFacility = objectFacility;
    }
}
