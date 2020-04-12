package com.example.data.datasource.db.store;

import android.content.Context;

import com.example.data.datasource.datastore.UserDataStore;
import com.example.data.datasource.db.DbInspec3Instance;
import com.example.data.datasource.db.dao.UserDAO;
import com.example.data.datasource.db.model.DbUser;
import com.example.data.mapper.UserDataMapper;
import com.example.domain.model.User;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

public class DbUserDataStore implements UserDataStore {

    UserDAO userDAO;

    public DbUserDataStore(Context context) {
        userDAO = DbInspec3Instance.getDatabase(context).userDAO();
    }

    @Override
    public void createUser(User user, RepositoryCallback repositoryCallback) {

        UserDataMapper userDataMapper = new UserDataMapper();
        DbUser dbUser = userDataMapper.transformToDb(user);

        dbUser.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            user.setId(
                    userDAO.InsertOnlyOne(dbUser).toString()
            );
            repositoryCallback.onSuccess(user);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void createUserList(
            List<User> userList,
            RepositoryCallback repositoryCallback) {

        UserDataMapper userDataMapper = new UserDataMapper();
//        DbUser dbUser=userDataMapper.transformToDb(user);

        List<DbUser> dbUserList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            User wrkUser = userList.get(i);
            DbUser wrkDbUser = userDataMapper.transformToDb(wrkUser);
            wrkDbUser.setId(null);     // para que se creen automáticamente
            dbUserList.add(wrkDbUser);
        }

//        dbUser.setId( 0 ); // o null?

        try {
            userDAO.InsertMultiple(dbUserList);     // tipos... ver domain/model/user
            repositoryCallback.onSuccess(userList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateUser(User user, RepositoryCallback repositoryCallback) {

        UserDataMapper userDataMapper = new UserDataMapper();
        DbUser dbUser = userDataMapper.transformToDb(user);

        dbUser.setId(Integer.parseInt(user.getId())); // ojo, verificar si null

        try {
            userDAO.updateById(
                    dbUser.getId().toString(),
                    dbUser.getEmail(),
                    dbUser.getPassword(),
                    dbUser.getName()

            );
            repositoryCallback.onSuccess(user);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void deleteUser(User user, RepositoryCallback repositoryCallback) {

        UserDataMapper userDataMapper = new UserDataMapper();
        DbUser dbUser = userDataMapper.transformToDb(user);

        try {
            if (dbUser.getPassword().equalsIgnoreCase("delete*ALL")) {
                userDAO.deleteAll();
            } else {
                userDAO.deleteById(dbUser.getId().toString());
            }
            repositoryCallback.onSuccess(user);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void usersList(RepositoryCallback repositoryCallback) {

        UserDataMapper userDataMapper = new UserDataMapper();
//        DbUser dbUser = userDataMapper.transformToDb(user);

        List<User> users = new ArrayList<>();
        User user;
        DbUser dbUser;

        try {
            List<DbUser> dbUsers = userDAO.listAllQ();

            for (int i = 0; i < dbUsers.size(); i++) {
//                System.out.println(crunchifyList.get(i));
                dbUser = dbUsers.get(i);
                user = userDataMapper.transformFromDb(dbUser);
                users.add(user);
            }
            repositoryCallback.onSuccess(users);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }


}
