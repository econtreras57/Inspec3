package com.example.interactor.user;

import com.example.domain.model.User;

import java.util.ArrayList;

public interface UserListCallback {
    void onUserListSuccess(ArrayList<User> userList);
    void onUserListError(String message);
}
