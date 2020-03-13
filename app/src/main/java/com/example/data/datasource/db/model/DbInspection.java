package com.example.data.datasource.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "DbInspection")
public class DbInspection implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;

    private String inspector;
    private String date;
    private String statusDate;
    private String status;
    private String subStatusDate;
    private String subStatus;
    private String planned;
    private String project;
    private String contractor;
    private String locType;
    private String site;
    private String responsible;

    public DbInspection(Integer id, String inspector, String date, String statusDate, String status, String subStatusDate, String subStatus, String planned, String project, String contractor, String locType, String site, String responsible) {
        this.id = id;
        this.inspector = inspector;
        this.date = date;
        this.statusDate = statusDate;
        this.status = status;
        this.subStatusDate = subStatusDate;
        this.subStatus = subStatus;
        this.planned = planned;
        this.project = project;
        this.contractor = contractor;
        this.locType = locType;
        this.site = site;
        this.responsible = responsible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getPlanned() {
        return planned;
    }

    public void setPlanned(String planned) {
        this.planned = planned;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
