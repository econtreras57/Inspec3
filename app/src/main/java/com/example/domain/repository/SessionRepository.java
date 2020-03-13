package com.example.domain.repository;

import com.example.domain.model.Session;
import com.example.interactor.session.SessionCreatedCallback;
import com.example.interactor.session.SessionDeletedCallback;
import com.example.interactor.session.SessionListCallback;
import com.example.interactor.session.SessionListCreatedCallback;
import com.example.interactor.session.SessionUpdatedCallback;

import java.util.List;

public interface SessionRepository {
    void createSession(
            Session session,
            int sessionDataLocation,
            SessionCreatedCallback sessionCreatedCallback);

    void createSessionList(
            List<Session> sessionList,
            int sessionDataLocation,
            SessionListCreatedCallback sessionListCreateCallback);   // 2020-02-10

    void updateSession(
            Session session,
            int sessionDataLocation,
            SessionUpdatedCallback sessionUpdatedCallback);

    void deleteSession(
            Session session,
            int sessionDataLocation,
            SessionDeletedCallback sessionDeletedCallback);

    void loadSessions(
            int sessionDataLocation,
            final SessionListCallback requestListCallback);
    
}
