package com.example.data.datasource.db.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DbParameterEntity")
public class DbParameterEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "idParameterSuperior")
    public String idParameterSuperior;
    @NonNull
    @ColumnInfo(name = "canShow")
    public boolean canShow;
    @NonNull
    @ColumnInfo(name = "canAdd")
    public boolean canAdd;
    @NonNull
    @ColumnInfo(name = "canDisabled")
    public boolean canDisabled;
    @NonNull
    @ColumnInfo(name = "canEdit")
    public boolean canEdit;
    @NonNull
    @ColumnInfo(name = "canDeleted")
    public boolean canDeleted;
    @ColumnInfo(name = "additional1")
    public String additional1;
    @ColumnInfo(name = "additional2")
    public String additional2;
    @ColumnInfo(name = "additional3")
    public String additional3;
    @NonNull
    @ColumnInfo(name = "deleted")
    public boolean deleted;

    public DbParameterEntity(
            @NonNull String id, @NonNull String name, String idParameterSuperior,
            @NonNull boolean canShow, @NonNull boolean canAdd, @NonNull boolean canDisabled,
            @NonNull boolean canEdit, @NonNull boolean canDeleted,
            String additional1, String additional2, String additional3,
            @NonNull boolean deleted) {
        this.id = id;
        this.name = name;
        this.idParameterSuperior = idParameterSuperior;
        this.canShow = canShow;
        this.canAdd = canAdd;
        this.canDisabled = canDisabled;
        this.canEdit = canEdit;
        this.canDeleted = canDeleted;
        this.additional1 = additional1;
        this.additional2 = additional2;
        this.additional3 = additional3;
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
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getIdParameterSuperior() {
        return idParameterSuperior;
    }

    public void setIdParameterSuperior(String idParameterSuperior) {
        this.idParameterSuperior = idParameterSuperior;
    }

    public boolean isCanShow() {
        return canShow;
    }

    public void setCanShow(boolean canShow) {
        this.canShow = canShow;
    }

    public boolean isCanAdd() {
        return canAdd;
    }

    public void setCanAdd(boolean canAdd) {
        this.canAdd = canAdd;
    }

    public boolean isCanDisabled() {
        return canDisabled;
    }

    public void setCanDisabled(boolean canDisabled) {
        this.canDisabled = canDisabled;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public boolean isCanDeleted() {
        return canDeleted;
    }

    public void setCanDeleted(boolean canDeleted) {
        this.canDeleted = canDeleted;
    }

    public String getAdditional1() {
        return additional1;
    }

    public void setAdditional1(String additional1) {
        this.additional1 = additional1;
    }

    public String getAdditional2() {
        return additional2;
    }

    public void setAdditional2(String additional2) {
        this.additional2 = additional2;
    }

    public String getAdditional3() {
        return additional3;
    }

    public void setAdditional3(String additional3) {
        this.additional3 = additional3;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}





