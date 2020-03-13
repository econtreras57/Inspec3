package com.example.data.datasource.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "DbFindings")
public class DbFindings implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;

    private String inspectionId;
    private String type;
    private String subType;
    private String management;
    private String text;
    private String photo_1;
    private String photo_2;
    private String riskLevel;
    private String date;
    private String statusDate;
    private String plannedClosureDate;
    private String status;

    public DbFindings(Integer id, String inspectionId, String type, String subType, String management, String text, String photo_1, String photo_2, String riskLevel, String date, String statusDate, String plannedClosureDate, String status) {
        this.id = id;
        this.inspectionId = inspectionId;
        this.type = type;
        this.subType = subType;
        this.management = management;
        this.text = text;
        this.photo_1 = photo_1;
        this.photo_2 = photo_2;
        this.riskLevel = riskLevel;
        this.date = date;
        this.statusDate = statusDate;
        this.plannedClosureDate = plannedClosureDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto_1() {
        return photo_1;
    }

    public void setPhoto_1(String photo_1) {
        this.photo_1 = photo_1;
    }

    public String getPhoto_2() {
        return photo_2;
    }

    public void setPhoto_2(String photo_2) {
        this.photo_2 = photo_2;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
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

    public String getPlannedClosureDate() {
        return plannedClosureDate;
    }

    public void setPlannedClosureDate(String plannedClosureDate) {
        this.plannedClosureDate = plannedClosureDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
