package com.example.interactor.user;

import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;

import java.util.List;

public class UserInteractor {

    private final UserRepository userRepository;

    public UserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(
            User user,
            int userDataLocation,
            UserCreatedCallback userCreatedCallback
    ) {
        userRepository.createUser(
                user,
                userDataLocation,
                userCreatedCallback);
    }

    public void createUserList(
            List<User> userList,
            int userDataLocation,
            UserListCreatedCallback userListCreatedCallback
    ) {
        userRepository.createUserList(
                userList,
                userDataLocation,
                userListCreatedCallback);
    }

    public void updateUser(
            User user,
            int userDataLocation,
            UserUpdatedCallback userUpdatedCallback
    ) {
        userRepository.updateUser(
                user,
                userDataLocation,
                userUpdatedCallback);
    }

    public void deleteUser(
            User user,
            int userDataLocation,
            UserDeletedCallback userDeletedCallback) {

        userRepository.deleteUser(
                user,
                userDataLocation,
                userDeletedCallback);
    }

    public void loadUsers(
            int userDataLocation,
            UserListCallback userListCallback) {
        userRepository.loadUsers(
                userDataLocation,
                userListCallback);
    }

}
