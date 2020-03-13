package com.example.interactor.user;

import com.example.domain.model.User;

public interface UserDeletedCallback {
    void onUserDeletedSuccess(User user);
    void onUserDeletedError(String message);

}
