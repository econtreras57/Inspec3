package com.example.interactor.user;

import com.example.domain.model.User;

public interface UserCreatedCallback {
    void onUserCreatedSuccess(User user);
    void onUserCreatedError(String message);
    
}
