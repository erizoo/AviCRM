package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTrap {

    @SerializedName("trap")
    @Expose
    private List<TrapModel> name;
    @SerializedName("pesticides")
    @Expose
    private List<ResponsePesticides> pesticides;
    @SerializedName("revizor")
    @Expose
    private List<ResponseRevizor> responseRevizor;
    @SerializedName("type")
    @Expose
    private List<ResponseTypeTrap> responseTypeTrap;
    @SerializedName("box")
    @Expose
    private List<ResponseBox> responseBox;

    public List<ResponsePesticides> getPesticides() {
        return pesticides;
    }

    public void setPesticides(List<ResponsePesticides> pesticides) {
        this.pesticides = pesticides;
    }

    public List<ResponseRevizor> getResponseRevizor() {
        return responseRevizor;
    }

    public void setResponseRevizor(List<ResponseRevizor> responseRevizor) {
        this.responseRevizor = responseRevizor;
    }

    public List<ResponseTypeTrap> getResponseTypeTrap() {
        return responseTypeTrap;
    }

    public void setResponseTypeTrap(List<ResponseTypeTrap> responseTypeTrap) {
        this.responseTypeTrap = responseTypeTrap;
    }

    public List<ResponseBox> getResponseBox() {
        return responseBox;
    }

    public void setResponseBox(List<ResponseBox> responseBox) {
        this.responseBox = responseBox;
    }

    public List<TrapModel> getName() {
        return name;
    }

    public void setName(List<TrapModel> name) {
        this.name = name;
    }
}
