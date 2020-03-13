package com.example.data.mapper;

import com.example.data.datasource.db.model.SessionDbEntity;
import com.example.domain.model.Session;

public class SessionDataMapper {

    public SessionDbEntity transformToDb(Session session)
    {
        SessionDbEntity sessionDbEntity= new SessionDbEntity(
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
        return sessionDbEntity;
    }

    public Session transformFromDb(SessionDbEntity sessionDbEntity)
    {
        Session session = new Session(
                sessionDbEntity.getId(),
                sessionDbEntity.getUsername(),
                sessionDbEntity.getMail(),
                sessionDbEntity.getName(),
                sessionDbEntity.getLastName(),
                sessionDbEntity.getFullName(),
                sessionDbEntity.getAuthDate(),
                sessionDbEntity.getLastAuthDate(),
                sessionDbEntity.getLastSyncDatePush(),
                sessionDbEntity.getLastSyncDatePull(),
                sessionDbEntity.getToken(),
                sessionDbEntity.getIdWarehouse(),
                sessionDbEntity.getIdCounting(),
                sessionDbEntity.getIdInventory(),
                sessionDbEntity.getIdInventoryCountingWarehouse()

                );
        return session;
    }
    
}
