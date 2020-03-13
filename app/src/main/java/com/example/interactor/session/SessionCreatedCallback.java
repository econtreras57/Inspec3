package com.example.interactor.session;

import com.example.domain.model.Session;

public interface SessionCreatedCallback {
    void onSessionCreatedSuccess(Session session);
    void onSessionCreatedError(String message);
    
}
