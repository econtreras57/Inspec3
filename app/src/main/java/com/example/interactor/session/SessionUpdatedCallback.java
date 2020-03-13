package com.example.interactor.session;

import com.example.domain.model.Session;

public interface SessionUpdatedCallback {
    void onSessionUpdatedSuccess(Session session);
    void onSessionUpdatedError(String message);

}
