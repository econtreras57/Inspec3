package com.example.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "Inspection")
public class Inspection
        implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @SerializedName("inspector")
    private String inspector;    // usuario
    @SerializedName("date")
    private String date;    // fecha inspección
    @SerializedName("statusDate")
    private String statusDate;    // fecha del último cambio de estado
    @SerializedName("status")
    private String status;   // estado inspección {open, close}

    @SerializedName("subStatusDate")
    private String subStatusDate;    // fecha del último cambio de estado
    @SerializedName("subStatus")
    private String subStatus;   // sub-estado inspección {pendiente de X}


    @SerializedName("plan")
    private String plan;    // tipo {planned, not planned}

    @SerializedName("project")
    private String project;    // proyecto
    @SerializedName("contractor")
    private String contractor;    //
    @SerializedName("locType")
    private String locType;    //
    @SerializedName("site")
    private String site;   //
    @SerializedName("responsible")
    private String responsible;   //

    @Ignore
    public Inspection(Integer id) {
        this.id = id;
    }

    public Inspection() {
//        this.id = id;
    }


    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getSubStatusDate() {
        return subStatusDate;
    }

    public void setSubStatusDate(String subStatusDate) {
        this.subStatusDate = subStatusDate;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }
}






