package com.example.data.datasource.datastore;

import com.example.domain.model.User;
import com.example.domain.repository.RepositoryCallback;

import java.util.List;

public interface UserDataStore {

    void createUser(User user,
                    RepositoryCallback repositoryCallback);

    void createUserList(List<User> userList,
                        RepositoryCallback repositoryCallback);

    void updateUser(User user,
                    RepositoryCallback repositoryCallback);

    void deleteUser(User user,
                    RepositoryCallback repositoryCallback);

    void usersList( RepositoryCallback repositoryCallback);


}
