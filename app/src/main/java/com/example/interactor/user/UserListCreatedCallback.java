package com.example.interactor.user;

import com.example.domain.model.User;

import java.util.List;

public interface UserListCreatedCallback {
    void onUserListCreatedSuccess(List<User> userList);
    void onUserListCreatedError(String message);

}
