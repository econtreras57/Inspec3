package com.example.presentation.presenter;

import com.example.data.datasource.datastore.UserDataStoreFactory;
import com.example.data.repository.UserDataRepository;
import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;
import com.example.interactor.user.UserCreatedCallback;
import com.example.interactor.user.UserDeletedCallback;
import com.example.interactor.user.UserInteractor;
import com.example.interactor.user.UserListCallback;
import com.example.interactor.user.UserListCreatedCallback;
import com.example.interactor.user.UserUpdatedCallback;
import com.example.presentation.view.UserView;

import java.util.ArrayList;
import java.util.List;


public class UserPresenter implements
        Presenter<UserView>,
        UserCreatedCallback,
        UserListCreatedCallback,
        UserUpdatedCallback,
        UserDeletedCallback,
        UserListCallback {

    private UserView userView;
    private UserInteractor userInteractor;

    public void createUser(User user, int userDataLocation) {
        userInteractor.createUser(
                user,
                userDataLocation,
                this);
    }

    public void createUserList(List<User> userList, int userDataLocation) {
        userInteractor.createUserList(
                userList,
                userDataLocation,
                this);
    }

    public void updateUser(User user, int userDataLocation) {
        userInteractor.updateUser(
                user,
                userDataLocation,
                this);
    }

    public void deleteUser(User user, int userDataLocation) {

        userInteractor.deleteUser(
                user,
                userDataLocation,
                this);
    }

    public void loadUsers(int userDataLocation) {
        userInteractor.loadUsers(
                userDataLocation,
                this);
    }

    @Override
    public void addView(UserView view) {
        this.userView = view;
        UserRepository requestRepository =
                new UserDataRepository(
                        new UserDataStoreFactory(this.userView.getContext())
                );
        userInteractor = new UserInteractor(requestRepository);
    }

    @Override
    public void removeView(UserView view) {

    }

    @Override
    public void onUserCreatedSuccess(User user) {
        userView.userCreated(user);
    }

    @Override
    public void onUserCreatedError(String message) {

    }

    @Override
    public void onUserUpdatedSuccess(User user) {
        userView.userUpdated(user);
    }

    @Override
    public void onUserUpdatedError(String message) {

    }

    @Override
    public void onUserDeletedSuccess(User user) {
        userView.userDeleted(user);
    }

    @Override
    public void onUserDeletedError(String message) {

    }

    @Override
    public void onUserListSuccess(ArrayList<User> userList) {
        userView.usersListLoaded((ArrayList<User>) userList);
    }

    @Override
    public void onUserListError(String message) {

    }

    @Override
    public void onUserListCreatedSuccess(List<User> userList) {
        userView.userCreatedList(userList);

    }

    @Override
    public void onUserListCreatedError(String message) {

    }
}
