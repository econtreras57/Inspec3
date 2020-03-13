package com.example.presentation.view;

import com.example.domain.model.Session;

import java.util.ArrayList;
import java.util.List;

public interface SessionView extends BaseView {
    void sessionCreated(Session session);

    void sessionCreatedList(List<Session> sessionList);

    void sessionUpdated(Session session);

    void sessionDeleted(Session session);

    void sessionsListLoaded(ArrayList<Session> sessions);

    void showErrorMessage(String message);
}
