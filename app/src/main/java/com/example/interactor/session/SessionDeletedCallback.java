package com.example.interactor.session;

import com.example.domain.model.Session;

public interface SessionDeletedCallback {
    void onSessionDeletedSuccess(Session session);
    void onSessionDeletedError(String message);

}
