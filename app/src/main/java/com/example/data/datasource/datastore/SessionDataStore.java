package com.example.data.datasource.datastore;

import com.example.domain.model.Session;
import com.example.domain.repository.RepositoryCallback;

import java.util.List;

public interface SessionDataStore {

    void createSession(Session session,
                    RepositoryCallback repositoryCallback);

    void createSessionList(List<Session> sessionList,
                        RepositoryCallback repositoryCallback);

    void updateSession(Session session,
                    RepositoryCallback repositoryCallback);

    void deleteSession(Session session,
                    RepositoryCallback repositoryCallback);

    void sessionsList(RepositoryCallback repositoryCallback);


}
