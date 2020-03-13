package com.example.interactor.session;

import com.example.domain.model.Session;
import com.example.domain.repository.SessionRepository;
import com.example.interactor.session.SessionCreatedCallback;
import com.example.interactor.session.SessionDeletedCallback;
import com.example.interactor.session.SessionListCallback;
import com.example.interactor.session.SessionListCreatedCallback;
import com.example.interactor.session.SessionUpdatedCallback;

import java.util.List;

public class SessionInteractor {

    private final SessionRepository sessionRepository;

    public SessionInteractor(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void createSession(
            Session session,
            int sessionDataLocation,
            SessionCreatedCallback sessionCreatedCallback
    ) {
        sessionRepository.createSession(
                session,
                sessionDataLocation,
                sessionCreatedCallback);
    }

    public void createSessionList(
            List<Session> sessionList,
            int sessionDataLocation,
            SessionListCreatedCallback sessionListCreatedCallback
    ) {
        sessionRepository.createSessionList(
                sessionList,
                sessionDataLocation,
                sessionListCreatedCallback);
    }

    public void updateSession(
            Session session,
            int sessionDataLocation,
            SessionUpdatedCallback sessionUpdatedCallback
    ) {
        sessionRepository.updateSession(
                session,
                sessionDataLocation,
                sessionUpdatedCallback);
    }

    public void deleteSession(
            Session session,
            int sessionDataLocation,
            SessionDeletedCallback sessionDeletedCallback) {

        sessionRepository.deleteSession(
                session,
                sessionDataLocation,
                sessionDeletedCallback);
    }

    public void loadSessions(
            int sessionDataLocation,
            SessionListCallback sessionListCallback) {
        sessionRepository.loadSessions(
                sessionDataLocation,
                sessionListCallback);
    }

}
