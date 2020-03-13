package com.example.data.datasource.db.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "ParameterValueDbEntity",
        foreignKeys = {
                @ForeignKey(entity = ParameterDbEntity.class, parentColumns = "id",
                        childColumns = "idParameter"),
        },
        indices = {@Index("idParameter")})

public class ParameterValueDbEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;
    @NonNull
    @ColumnInfo(name = "idParameter")
    public String idParameter; // Parameter.id
    @ColumnInfo(name = "idParameterValueSuperior")
    public String idParameterValueSuperior; // ParameterValue.id
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    @NonNull
    @ColumnInfo(name = "value")
    public String value;
    @NonNull
    @ColumnInfo(name = "valueFull")
    public String valueFull;
    @ColumnInfo(name = "valueAdditional1")
    public String valueAdditional1;
    @ColumnInfo(name = "valueAdditional2")
    public String valueAdditional2;
    @ColumnInfo(name = "valueAdditional3")
    public String valueAdditional3;
    @ColumnInfo(name = "order")
    public int order;
    @NonNull
    @ColumnInfo(name = "enable")
    public boolean enable;
    @ColumnInfo(name = "idUserRegister")
    public String idUserRegister;
    @ColumnInfo(name = "idUserModify")
    public String idUserModify;
    @ColumnInfo(name = "dateRegister")
    public Date dateRegister;
    @ColumnInfo(name = "dateModify")
    public Date dateModify;
    @NonNull
    @ColumnInfo(name = "deleted")
    public boolean deleted;

    public ParameterValueDbEntity(@NonNull String id, @NonNull String idParameter,
                                  String idParameterValueSuperior, @NonNull String name,
                                  @NonNull String value, String valueFull, String valueAdditional1,
                                  String valueAdditional2, String valueAdditional3, int order,
                                  @NonNull boolean enable, String idUserRegister,
                                  String idUserModify, Date dateRegister, Date dateModify,
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
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

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}





