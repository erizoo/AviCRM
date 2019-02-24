package ru.specaviagroup.lk.aviacrm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyNeedRep;
import ru.specaviagroup.lk.aviacrm.data.request.RequestGlutRepTrap;

public class RequestAll {

    @SerializedName("flyActive")
    @Expose
    private RequestFlyActive requestFlyActive;
    @SerializedName("glutRepTrap")
    @Expose
    private RequestGlutRepTrap requestGlutRepTrap;
    @SerializedName("flyNeedRep")
    @Expose
    private RequestFlyNeedRep requestFlyNeedRep;
    @SerializedName("flyControlProf")
    @Expose
    private RequestPreventiveActions requestPreventiveAction;
    @SerializedName("wasRemoveTrap")
    @Expose
    private RequestWasRemoveTrap requestWasRemoveTrap;
    @SerializedName("wasBrokenTrap")
    @Expose
    private RequestWasBrokenTrap requestWasBrokenTrap;
    @SerializedName("wasDisableTrap")
    @Expose
    private RequestWasDisableTrap requestWasDisableTrap;
    @SerializedName("questPersonal")
    @Expose
    private RequestQuestPersonal requestQuestPersonal;
    @SerializedName("wasAlivePests")
    @Expose
    private RequestWasAlivePests requestWasAlivePests;
    @SerializedName("wasTrashPests")
    @Expose
    private RequestWasTrashPests requestWasTrashPests;
    @SerializedName("wasHolePest")
    @Expose
    private RequestWasHolePest requestWasHolePest;
    @SerializedName("wasDis")
    @Expose
    private RequestWasDis requestWasDis;

    public RequestFlyActive getRequestFlyActive() {
        return requestFlyActive;
    }

    public void setRequestFlyActive(RequestFlyActive requestFlyActive) {
        this.requestFlyActive = requestFlyActive;
    }

    public RequestGlutRepTrap getRequestGlutRepTrap() {
        return requestGlutRepTrap;
    }

    public void setRequestGlutRepTrap(RequestGlutRepTrap requestGlutRepTrap) {
        this.requestGlutRepTrap = requestGlutRepTrap;
    }

    public RequestFlyNeedRep getRequestFlyNeedRep() {
        return requestFlyNeedRep;
    }

    public void setRequestFlyNeedRep(RequestFlyNeedRep requestFlyNeedRep) {
        this.requestFlyNeedRep = requestFlyNeedRep;
    }

    public RequestPreventiveActions getRequestPreventiveAction() {
        return requestPreventiveAction;
    }

    public void setRequestPreventiveAction(RequestPreventiveActions requestPreventiveAction) {
        this.requestPreventiveAction = requestPreventiveAction;
    }

    public RequestWasRemoveTrap getRequestWasRemoveTrap() {
        return requestWasRemoveTrap;
    }

    public void setRequestWasRemoveTrap(RequestWasRemoveTrap requestWasRemoveTrap) {
        this.requestWasRemoveTrap = requestWasRemoveTrap;
    }

    public RequestWasBrokenTrap getRequestWasBrokenTrap() {
        return requestWasBrokenTrap;
    }

    public void setRequestWasBrokenTrap(RequestWasBrokenTrap requestWasBrokenTrap) {
        this.requestWasBrokenTrap = requestWasBrokenTrap;
    }

    public RequestWasDisableTrap getRequestWasDisableTrap() {
        return requestWasDisableTrap;
    }

    public void setRequestWasDisableTrap(RequestWasDisableTrap requestWasDisableTrap) {
        this.requestWasDisableTrap = requestWasDisableTrap;
    }

    public RequestQuestPersonal getRequestQuestPersonal() {
        return requestQuestPersonal;
    }

    public void setRequestQuestPersonal(RequestQuestPersonal requestQuestPersonal) {
        this.requestQuestPersonal = requestQuestPersonal;
    }

    public RequestWasAlivePests getRequestWasAlivePests() {
        return requestWasAlivePests;
    }

    public void setRequestWasAlivePests(RequestWasAlivePests requestWasAlivePests) {
        this.requestWasAlivePests = requestWasAlivePests;
    }

    public RequestWasTrashPests getRequestWasTrashPests() {
        return requestWasTrashPests;
    }

    public void setRequestWasTrashPests(RequestWasTrashPests requestWasTrashPests) {
        this.requestWasTrashPests = requestWasTrashPests;
    }

    public RequestWasHolePest getRequestWasHolePest() {
        return requestWasHolePest;
    }

    public void setRequestWasHolePest(RequestWasHolePest requestWasHolePest) {
        this.requestWasHolePest = requestWasHolePest;
    }

    public RequestWasDis getRequestWasDis() {
        return requestWasDis;
    }

    public void setRequestWasDis(RequestWasDis requestWasDis) {
        this.requestWasDis = requestWasDis;
    }
}
