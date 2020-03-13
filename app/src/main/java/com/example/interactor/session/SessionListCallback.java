package com.example.interactor.session;

import com.example.domain.model.Session;

import java.util.ArrayList;

public interface SessionListCallback {
    void onSessionListSuccess(ArrayList<Session> sessionList);
    void onSessionListError(String message);
}
