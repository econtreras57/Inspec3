package com.example.data.datasource.db.store;

import android.content.Context;

import com.example.data.datasource.datastore.SessionDataStore;
import com.example.data.datasource.db.Inspec3Db;
import com.example.data.datasource.db.dao.SessionDAO;
import com.example.data.datasource.db.model.SessionDbEntity;
import com.example.data.mapper.SessionDataMapper;
import com.example.domain.model.Session;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

public class SessionDbEntityDataStore implements SessionDataStore {

    SessionDAO sessionDAO;

    public SessionDbEntityDataStore(Context context) {
        sessionDAO = Inspec3Db.getDatabase(context).sessionDAO();
    }

    @Override
    public void createSession(Session session, RepositoryCallback repositoryCallback) {

        SessionDataMapper sessionDataMapper = new SessionDataMapper();
        SessionDbEntity sessionDbEntity = sessionDataMapper.transformToDb(session);

        sessionDbEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            session.setId(
                    sessionDAO.InsertOnlyOne(sessionDbEntity).toString()
            );
            repositoryCallback.onSuccess(session);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void createSessionList(
            List<Session> sessionList,
            RepositoryCallback repositoryCallback) {

        SessionDataMapper sessionDataMapper = new SessionDataMapper();
//        SessionDbEntity sessionDbEntity=sessionDataMapper.transformToDb(session);

        List<SessionDbEntity> sessionDbEntityList = new ArrayList<>();
        for (int i = 0; i < sessionList.size(); i++) {
            Session wrkSession = sessionList.get(i);
            SessionDbEntity wrkSessionDbEntity = sessionDataMapper.transformToDb(wrkSession);
            wrkSessionDbEntity.setId(null);     // para que se creen automáticamente
            sessionDbEntityList.add(wrkSessionDbEntity);
        }

//        sessionDbEntity.setId( 0 ); // o null?

        try {
            sessionDAO.InsertMultiple(sessionDbEntityList);     // tipos... ver domain/model/session
            repositoryCallback.onSuccess(sessionList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateSession(Session session, RepositoryCallback repositoryCallback) {

        SessionDataMapper sessionDataMapper = new SessionDataMapper();
        SessionDbEntity sessionDbEntity = sessionDataMapper.transformToDb(session);

        sessionDbEntity.setId(session.getId()); // ojo, verificar si null

        try {
            sessionDAO.updateById(
                    sessionDbEntity.getId(),
                    sessionDbEntity.getUsername(),
                    sessionDbEntity.getMail(),
                    sessionDbEntity.getName(),
                    sessionDbEntity.getLastName(),
                    sessionDbEntity.getFullName(),
                    sessionDbEntity.getAuthDate().toString(),
                    sessionDbEntity.getLastAuthDate().toString(),
                    sessionDbEntity.getLastSyncDatePush().toString(),
                    sessionDbEntity.getLastSyncDatePull().toString(),
                    sessionDbEntity.getToken(),
                    sessionDbEntity.getIdWarehouse(),
                    sessionDbEntity.getIdCounting(),
                    sessionDbEntity.getIdInventory(),
                    sessionDbEntity.getIdInventoryCountingWarehouse()

                    );
            repositoryCallback.onSuccess(session);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void deleteSession(Session session, RepositoryCallback repositoryCallback) {

        SessionDataMapper sessionDataMapper = new SessionDataMapper();
        SessionDbEntity sessionDbEntity = sessionDataMapper.transformToDb(session);

        try {
            if (sessionDbEntity.getName().equalsIgnoreCase("delete*ALL")) {
                sessionDAO.deleteAll();
            } else {
                sessionDAO.deleteById(sessionDbEntity.getId().toString());
            }
            repositoryCallback.onSuccess(session);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void sessionsList(RepositoryCallback repositoryCallback) {

        SessionDataMapper sessionDataMapper = new SessionDataMapper();
//        SessionDbEntity sessionDbEntity = sessionDataMapper.transformToDb(session);

        List<Session> sessions = new ArrayList<>();
        Session session;
        SessionDbEntity sessionDbEntity;

        try {
            List<SessionDbEntity> sessionDbEntitys = sessionDAO.listAllQ();

            for (int i = 0; i < sessionDbEntitys.size(); i++) {
                sessionDbEntity = sessionDbEntitys.get(i);
                session = sessionDataMapper.transformFromDb(sessionDbEntity);
                sessions.add(session);
            }
            repositoryCallback.onSuccess(sessions);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

}
