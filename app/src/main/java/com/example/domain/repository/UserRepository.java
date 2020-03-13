package com.example.domain.repository;

import com.example.domain.model.User;
import com.example.interactor.user.UserCreatedCallback;
import com.example.interactor.user.UserDeletedCallback;
import com.example.interactor.user.UserListCallback;
import com.example.interactor.user.UserListCreatedCallback;
import com.example.interactor.user.UserUpdatedCallback;

import java.util.List;

public interface UserRepository {
    void createUser(
            User user,
            int userDataLocation,
            UserCreatedCallback userCreatedCallback);

    void createUserList(
            List<User> userList,
            int userDataLocation,
            UserListCreatedCallback userListCreateCallback);   // 2020-02-10

    void updateUser(
            User user,
            int userDataLocation,
            UserUpdatedCallback userUpdatedCallback);

    void deleteUser(
            User user,
            int userDataLocation,
            UserDeletedCallback userDeletedCallback);

    void loadUsers(
            int userDataLocation,
            final UserListCallback requestListCallback);
    
}
