package com.example.presentation.view;

import com.example.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserView extends BaseView {
    void userCreated(User user);

    void userCreatedList(List<User> userList);

    void userUpdated(User user);

    void userDeleted(User user);

    void usersListLoaded(ArrayList<User> users);

    void showErrorMessage(String message);
}
