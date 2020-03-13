package com.example.interactor.session;

import com.example.domain.model.Session;

import java.util.List;

public interface SessionListCreatedCallback {
    void onSessionListCreatedSuccess(List<Session> sessionList);
    void onSessionListCreatedError(String message);

}
