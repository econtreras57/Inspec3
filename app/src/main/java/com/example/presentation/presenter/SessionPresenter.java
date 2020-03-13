package com.example.presentation.presenter;

import com.example.data.datasource.datastore.SessionDataStoreFactory;
import com.example.data.repository.SessionDataRepository;
import com.example.domain.model.Session;
import com.example.domain.repository.SessionRepository;
import com.example.interactor.session.SessionCreatedCallback;
import com.example.interactor.session.SessionDeletedCallback;
import com.example.interactor.session.SessionInteractor;
import com.example.interactor.session.SessionListCallback;
import com.example.interactor.session.SessionListCreatedCallback;
import com.example.interactor.session.SessionUpdatedCallback;
import com.example.presentation.view.SessionView;

import java.util.ArrayList;
import java.util.List;


public class SessionPresenter implements
        Presenter<SessionView>,
        SessionCreatedCallback,
        SessionListCreatedCallback,
        SessionUpdatedCallback,
        SessionDeletedCallback,
        SessionListCallback {

    private SessionView sessionView;
    private SessionInteractor sessionInteractor;

    public void createSession(Session session, int sessionDataLocation) {
        sessionInteractor.createSession(
                session,
                sessionDataLocation,
                this);
    }

    public void createSessionList(List<Session> sessionList, int sessionDataLocation) {
        sessionInteractor.createSessionList(
                sessionList,
                sessionDataLocation,
                this);
    }

    public void updateSession(Session session, int sessionDataLocation) {
        sessionInteractor.updateSession(
                session,
                sessionDataLocation,
                this);
    }

    public void deleteSession(Session session, int sessionDataLocation) {

        sessionInteractor.deleteSession(
                session,
                sessionDataLocation,
                this);
    }

    public void loadSessions(int sessionDataLocation) {
        sessionInteractor.loadSessions(
                sessionDataLocation,
                this);
    }

    @Override
    public void addView(SessionView view) {
        this.sessionView = view;
        SessionRepository requestRepository =
                new SessionDataRepository(
                        new SessionDataStoreFactory(this.sessionView.getContext())
                );
        sessionInteractor = new SessionInteractor(requestRepository);
    }

    @Override
    public void removeView(SessionView view) {

    }

    @Override
    public void onSessionCreatedSuccess(Session session) {
        sessionView.sessionCreated(session);
    }

    @Override
    public void onSessionCreatedError(String message) {

    }

    @Override
    public void onSessionUpdatedSuccess(Session session) {
        sessionView.sessionUpdated(session);
    }

    @Override
    public void onSessionUpdatedError(String message) {

    }

    @Override
    public void onSessionDeletedSuccess(Session session) {
        sessionView.sessionDeleted(session);
    }

    @Override
    public void onSessionDeletedError(String message) {

    }

    @Override
    public void onSessionListSuccess(ArrayList<Session> sessionList) {
        sessionView.sessionsListLoaded((ArrayList<Session>) sessionList);
    }

    @Override
    public void onSessionListError(String message) {

    }

    @Override
    public void onSessionListCreatedSuccess(List<Session> sessionList) {
        sessionView.sessionCreatedList(sessionList);

    }

    @Override
    public void onSessionListCreatedError(String message) {

    }
}
