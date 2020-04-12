package com.example.data.datasource.db.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "DbSessionEntity")
public class DbSessionEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;
    @NonNull
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "mail")
    public String mail;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "lastName")
    public String lastName;
    @ColumnInfo(name = "fullName")
    public String fullName;
    @ColumnInfo(name = "authDate")
    public Date authDate;
    @ColumnInfo(name = "lastAuthDate")
    public Date lastAuthDate;
    @ColumnInfo(name = "lastSyncDatePush")
    public Date lastSyncDatePush;
    @ColumnInfo(name = "lastSyncDatePull")
    public Date lastSyncDatePull;
    @NonNull
    @ColumnInfo(name = "token")
    public String token;
    @ColumnInfo(name = "idWarehouse")
    public String idWarehouse;
    @ColumnInfo(name = "idCounting")
    public String idCounting;
    @ColumnInfo(name = "idInventory")
    public String idInventory;
    @ColumnInfo(name = "idInventoryCountingWarehouse")
    public String idInventoryCountingWarehouse;

    public DbSessionEntity(@NonNull String id, @NonNull String username, String mail, String name,
                           String lastName, String fullName, Date authDate, Date lastAuthDate,
                           Date lastSyncDatePush, Date lastSyncDatePull, @NonNull String token,
                           String idWarehouse, String idCounting, String idInventory,
                           String idInventoryCountingWarehouse) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.name = name;
        this.lastName = lastName;
        this.fullName = fullName;
        this.authDate = authDate;
        this.lastAuthDate = lastAuthDate;
        this.lastSyncDatePush = lastSyncDatePush;
        this.lastSyncDatePull = lastSyncDatePull;
        this.token = token;
        this.idWarehouse = idWarehouse;
        this.idCounting = idCounting;
        this.idInventory = idInventory;
        this.idInventoryCountingWarehouse = idInventoryCountingWarehouse;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getAuthDate() {
        return authDate;
    }

    public void setAuthDate(Date authDate) {
        this.authDate = authDate;
    }

    public Date getLastAuthDate() {
        return lastAuthDate;
    }

    public void setLastAuthDate(Date lastAuthDate) {
        this.lastAuthDate = lastAuthDate;
    }

    public Date getLastSyncDatePush() {
        return lastSyncDatePush;
    }

    public void setLastSyncDatePush(Date lastSyncDatePush) {
        this.lastSyncDatePush = lastSyncDatePush;
    }

    public Date getLastSyncDatePull() {
        return lastSyncDatePull;
    }

    public void setLastSyncDatePull(Date lastSyncDatePull) {
        this.lastSyncDatePull = lastSyncDatePull;
    }

    @NonNull
    public String getToken() {
        return token;
    }

    public void setToken(@NonNull String token) {
        this.token = token;
    }

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getIdCounting() {
        return idCounting;
    }

    public void setIdCounting(String idCounting) {
        this.idCounting = idCounting;
    }

    public String getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(String idInventory) {
        this.idInventory = idInventory;
    }

    public String getIdInventoryCountingWarehouse() {
        return idInventoryCountingWarehouse;
    }

    public void setIdInventoryCountingWarehouse(String idInventoryCountingWarehouse) {
        this.idInventoryCountingWarehouse = idInventoryCountingWarehouse;
    }
}





