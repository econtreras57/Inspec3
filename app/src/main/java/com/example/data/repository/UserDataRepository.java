package com.example.data.repository;

import com.example.data.datasource.datastore.UserDataStore;
import com.example.data.datasource.datastore.UserDataStoreFactory;
import com.example.domain.model.User;
import com.example.domain.repository.RepositoryCallback;
import com.example.domain.repository.UserRepository;
import com.example.interactor.user.UserCreatedCallback;
import com.example.interactor.user.UserDeletedCallback;
import com.example.interactor.user.UserListCallback;
import com.example.interactor.user.UserListCreatedCallback;
import com.example.interactor.user.UserUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;

    public UserDataRepository(
            UserDataStoreFactory userDataStoreFactory) {
        this.userDataStoreFactory = userDataStoreFactory;
    }

    @Override
    public void createUser(
            User user,
            int userDataLocation,
            final UserCreatedCallback userCreatedCallback) {    // ¿final? 2020-03-12

        final UserDataStore userDataStore = userDataStoreFactory.create(
//                userDataStoreFactory.CLOUD,
                userDataLocation
//                FirebaseFirestore.getInstance()
        );

        userDataStore.createUser(user, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                userCreatedCallback.onUserCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                User newUser = (User) object;
                userCreatedCallback.onUserCreatedSuccess(newUser);
            }
        });
    }

    @Override
    public void createUserList(
            List<User> userList,
            int userDataLocation,
            final UserListCreatedCallback userListCreateCallback) {

        final UserDataStore userDataStore = userDataStoreFactory.create(
//                userDataStoreFactory.CLOUD,
                userDataLocation
//                FirebaseFirestore.getInstance()
        );

        userDataStore.createUserList(userList, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                userListCreateCallback.onUserListCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                List<User> newUserList = (List<User>) object;
                userListCreateCallback.onUserListCreatedSuccess(newUserList);
            }
        });
    }

    @Override
    public void updateUser(
            User user,
            int userDataLocation,
            final UserUpdatedCallback userUpdatedCallback) {

        final UserDataStore userDataStore = userDataStoreFactory.create(
//                userDataStoreFactory.CLOUD,
                userDataLocation
//                FirebaseFirestore.getInstance()
        );

        userDataStore.updateUser(user, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                userUpdatedCallback.onUserUpdatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                User updUser = (User) object;
                userUpdatedCallback.onUserUpdatedSuccess(updUser);
            }
        });

    }

    @Override
    public void deleteUser(
            User user,
            int userDataLocation,
            final UserDeletedCallback userDeletedCallback) {

        final UserDataStore userDataStore;

        userDataStore = userDataStoreFactory.create(
                userDataLocation
//                FirebaseFirestore.getInstance()
        );

        userDataStore.deleteUser(user, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                userDeletedCallback.onUserDeletedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                User updUser = (User) object;
                userDeletedCallback.onUserDeletedSuccess(updUser);
            }
        });

    }

    @Override
    public void loadUsers(
            int userDataLocation,
            final UserListCallback requestListCallback) {

        final UserDataStore userDataStore = userDataStoreFactory.create(
//                userDataStoreFactory.CLOUD, FirebaseFirestore.getInstance());
                userDataLocation
//                FirebaseFirestore.getInstance()
        );

        userDataStore.usersList(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                requestListCallback.onUserListError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<User> userArrayList = (ArrayList<User>) object;
                requestListCallback.onUserListSuccess(userArrayList);
            }
        });


    }

}
