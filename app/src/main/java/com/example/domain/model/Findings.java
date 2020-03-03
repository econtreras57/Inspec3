package com.example.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "Findings")
public class Findings
        implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;

    @SerializedName("inspectionId")
    private String inspectionId;    // header record is inspection
    @SerializedName("type")
    private String type;    // tipo {act, condition}
    @SerializedName("subType")
    private String subType;    // ... {acto: no usar x, condición: no tiene procedimiento, falta x}
    @SerializedName("management")
    private String management;    // gestión
    @SerializedName("text")
    private String text;    // descripción del caso
    @SerializedName("photo_1")
    private String photo_1;   //
    @SerializedName("photo_2")
    private String photo_2;   //
    @SerializedName("riskLevel")
    private String riskLevel;   //
    @SerializedName("date")
    private String date;   // date of finding
    @SerializedName("statusDate")
    private String statusDate;   // date of last status
    @SerializedName("planedClosureDate")
    private String plannedClosureDate;   // estimated date of closure
    @SerializedName("status")
    private String status;   // estimated date of closure


    @Ignore
    public Findings(Integer id) {
        this.id = id;
    }

    public Findings() {
//        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }
}
