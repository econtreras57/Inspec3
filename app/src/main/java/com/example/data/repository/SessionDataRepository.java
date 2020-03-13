package com.example.data.repository;

import com.example.data.datasource.datastore.SessionDataStore;
import com.example.data.datasource.datastore.SessionDataStoreFactory;
import com.example.domain.model.Session;
import com.example.domain.repository.RepositoryCallback;
import com.example.domain.repository.SessionRepository;
import com.example.interactor.session.SessionCreatedCallback;
import com.example.interactor.session.SessionDeletedCallback;
import com.example.interactor.session.SessionListCallback;
import com.example.interactor.session.SessionListCreatedCallback;
import com.example.interactor.session.SessionUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class SessionDataRepository implements SessionRepository {

    private final SessionDataStoreFactory sessionDataStoreFactory;

    public SessionDataRepository(
            SessionDataStoreFactory sessionDataStoreFactory) {
        this.sessionDataStoreFactory = sessionDataStoreFactory;
    }

    @Override
    public void createSession(
            Session session,
            int sessionDataLocation,
            final SessionCreatedCallback sessionCreatedCallback) {    // ¿final? 2020-03-12

        final SessionDataStore sessionDataStore = sessionDataStoreFactory.create(
//                sessionDataStoreFactory.CLOUD,
                sessionDataLocation
//                FirebaseFirestore.getInstance()
        );

        sessionDataStore.createSession(session, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                sessionCreatedCallback.onSessionCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Session newSession = (Session) object;
                sessionCreatedCallback.onSessionCreatedSuccess(newSession);
            }
        });
    }

    @Override
    public void createSessionList(
            List<Session> sessionList,
            int sessionDataLocation,
            final SessionListCreatedCallback sessionListCreateCallback) {

        final SessionDataStore sessionDataStore = sessionDataStoreFactory.create(
//                sessionDataStoreFactory.CLOUD,
                sessionDataLocation
//                FirebaseFirestore.getInstance()
        );

        sessionDataStore.createSessionList(sessionList, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                sessionListCreateCallback.onSessionListCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                List<Session> newSessionList = (List<Session>) object;
                sessionListCreateCallback.onSessionListCreatedSuccess(newSessionList);
            }
        });
    }

    @Override
    public void updateSession(
            Session session,
            int sessionDataLocation,
            final SessionUpdatedCallback sessionUpdatedCallback) {

        final SessionDataStore sessionDataStore = sessionDataStoreFactory.create(
//                sessionDataStoreFactory.CLOUD,
                sessionDataLocation
//                FirebaseFirestore.getInstance()
        );

        sessionDataStore.updateSession(session, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                sessionUpdatedCallback.onSessionUpdatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Session updSession = (Session) object;
                sessionUpdatedCallback.onSessionUpdatedSuccess(updSession);
            }
        });

    }

    @Override
    public void deleteSession(
            Session session,
            int sessionDataLocation,
            final SessionDeletedCallback sessionDeletedCallback) {

        final SessionDataStore sessionDataStore;

        sessionDataStore = sessionDataStoreFactory.create(
                sessionDataLocation
//                FirebaseFirestore.getInstance()
        );

        sessionDataStore.deleteSession(session, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                sessionDeletedCallback.onSessionDeletedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Session updSession = (Session) object;
                sessionDeletedCallback.onSessionDeletedSuccess(updSession);
            }
        });

    }

    @Override
    public void loadSessions(
            int sessionDataLocation,
            final SessionListCallback requestListCallback) {

        final SessionDataStore sessionDataStore = sessionDataStoreFactory.create(
//                sessionDataStoreFactory.CLOUD, FirebaseFirestore.getInstance());
                sessionDataLocation
//                FirebaseFirestore.getInstance()
        );

        sessionDataStore.sessionsList(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                requestListCallback.onSessionListError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<Session> sessionArrayList = (ArrayList<Session>) object;
                requestListCallback.onSessionListSuccess(sessionArrayList);
            }
        });


    }

}
