package com.example.interactor.user;

import com.example.domain.model.User;

public interface UserUpdatedCallback {
    void onUserUpdatedSuccess(User user);
    void onUserUpdatedError(String message);

}
