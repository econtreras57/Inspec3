package com.example.data.datasource.cloud.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.data.datasource.db.model.DbParameterEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "ParameterValueCloudEntity",
        foreignKeys = {
                @ForeignKey(entity = DbParameterEntity.class, parentColumns = "id",
                        childColumns = "idParameter"),
        },
        indices = {@Index("idParameter")})

public class CloudParameterValueEntity {

    // 2020-05-13 Probando @SerializedName

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    public String id;
    @NonNull
    @ColumnInfo(name = "idParameter")
    @SerializedName("idParameter")
    @Expose
    public String idParameter; // Parameter.id
    @ColumnInfo(name = "idParameterValueSuperior")
    @SerializedName("idParameterValueSuperior")
    @Expose
    public String idParameterValueSuperior; // ParameterValue.id
    @NonNull
    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    public String name;
    @NonNull
    @ColumnInfo(name = "value")
    @SerializedName("value")
    @Expose
    public String value;
    @NonNull
    @ColumnInfo(name = "valueFull")
    @SerializedName("valueFull")
    @Expose
    public String valueFull;
    @ColumnInfo(name = "valueAdditional1")
    @SerializedName("valueAdditional1")
    @Expose
    public String valueAdditional1;
    @ColumnInfo(name = "valueAdditional2")
    @SerializedName("valueAdditional2")
    @Expose
    public String valueAdditional2;
    @ColumnInfo(name = "valueAdditional3")
    @SerializedName("valueAdditional3")
    @Expose
    public String valueAdditional3;
    @ColumnInfo(name = "order")
    @SerializedName("order")
    @Expose
    public String order;    // antes int
    @NonNull
    @ColumnInfo(name = "enable")
    @SerializedName("enable")
    @Expose
    public String enable;   // boolean
    @ColumnInfo(name = "idUserRegister")
    @SerializedName("idUserRegister")
    @Expose
    public String idUserRegister;
    @ColumnInfo(name = "idUserModify")
    @SerializedName("idUserModify")
    @Expose
    public String idUserModify;
    @ColumnInfo(name = "dateRegister")
    @SerializedName("dateRegister")
    @Expose
    public String dateRegister;   // Date
    @ColumnInfo(name = "dateModify")
    @SerializedName("dateModify")
    @Expose
    public String dateModify;     // Date
    @NonNull
    @ColumnInfo(name = "deleted")
    @SerializedName("deleted")
    @Expose
    public boolean deleted;

    public CloudParameterValueEntity(
            @NonNull String id,
            @NonNull String idParameter,
            String idParameterValueSuperior,
            @NonNull String name,
            @NonNull String value,
            String valueFull,
            String valueAdditional1,
            String valueAdditional2,
            String valueAdditional3,
            String order,       // int
            @NonNull String enable, // boolean
            String idUserRegister,
            String idUserModify,
            String dateRegister,      // Date
            String dateModify,        // Date
            @NonNull boolean deleted) {
        this.id = id;
        this.idParameter = idParameter;
        this.idParameterValueSuperior = idParameterValueSuperior;
        this.name = name;
        this.value = value;
        this.valueFull = valueFull;
        this.valueAdditional1 = valueAdditional1;
        this.valueAdditional2 = valueAdditional2;
        this.valueAdditional3 = valueAdditional3;
        this.order = order;
        this.enable = enable;
        this.idUserRegister = idUserRegister;
        this.idUserModify = idUserModify;
        this.dateRegister = dateRegister;
        this.dateModify = dateModify;
        this.deleted = deleted;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(@NonNull String idParameter) {
        this.idParameter = idParameter;
    }

    public String getIdParameterValueSuperior() {
        return idParameterValueSuperior;
    }

    public void setIdParameterValueSuperior(String idParameterValueSuperior) {
        this.idParameterValueSuperior = idParameterValueSuperior;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getValue() {
        return value;
    }

    public void setValue(@NonNull String value) {
        this.value = value;
    }

    @NonNull
    public String getValueFull() {
        return valueFull;
    }

    public void setValueFull(@NonNull String valueFull) {
        this.valueFull = valueFull;
    }

    public String getValueAdditional1() {
        return valueAdditional1;
    }

    public void setValueAdditional1(String valueAdditional1) {
        this.valueAdditional1 = valueAdditional1;
    }

    public String getValueAdditional2() {
        return valueAdditional2;
    }

    public void setValueAdditional2(String valueAdditional2) {
        this.valueAdditional2 = valueAdditional2;
    }

    public String getValueAdditional3() {
        return valueAdditional3;
    }

    public void setValueAdditional3(String valueAdditional3) {
        this.valueAdditional3 = valueAdditional3;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String isEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getIdUserRegister() {
        return idUserRegister;
    }

    public void setIdUserRegister(String idUserRegister) {
        this.idUserRegister = idUserRegister;
    }

    public String getIdUserModify() {
        return idUserModify;
    }

    public void setIdUserModify(String idUserModify) {
        this.idUserModify = idUserModify;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getDateModify() {
        return dateModify;
    }

    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}





