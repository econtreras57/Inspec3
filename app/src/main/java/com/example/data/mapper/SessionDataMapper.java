package com.example.data.mapper;

import com.example.data.datasource.db.model.DbSessionEntity;
import com.example.domain.model.Session;

public class SessionDataMapper {

    public DbSessionEntity transformToDb(Session session)
    {
        DbSessionEntity dbSessionEntity = new DbSessionEntity(
                session.getId(),
                session.getUsername(),
                session.getMail(),
                session.getName(),
                session.getLastName(),
                session.getFullName(),
                session.getAuthDate(),
                session.getLastAuthDate(),
                session.getLastSyncDatePush(),
                session.getLastSyncDatePull(),
                session.getToken(),
                session.getIdWarehouse(),
                session.getIdCounting(),
                session.getIdInventory(),
                session.getIdInventoryCountingWarehouse()

                );
        return dbSessionEntity;
    }

    public Session transformFromDb(DbSessionEntity dbSessionEntity)
    {
        Session session = new Session(
                dbSessionEntity.getId(),
                dbSessionEntity.getUsername(),
                dbSessionEntity.getMail(),
                dbSessionEntity.getName(),
                dbSessionEntity.getLastName(),
                dbSessionEntity.getFullName(),
                dbSessionEntity.getAuthDate(),
                dbSessionEntity.getLastAuthDate(),
                dbSessionEntity.getLastSyncDatePush(),
                dbSessionEntity.getLastSyncDatePull(),
                dbSessionEntity.getToken(),
                dbSessionEntity.getIdWarehouse(),
                dbSessionEntity.getIdCounting(),
                dbSessionEntity.getIdInventory(),
                dbSessionEntity.getIdInventoryCountingWarehouse()

                );
        return session;
    }
    
}
