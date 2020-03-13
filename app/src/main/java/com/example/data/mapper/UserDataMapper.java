package com.example.data.mapper;

import com.example.data.datasource.db.model.DbUser;
import com.example.domain.model.User;

public class UserDataMapper {

    public DbUser transformToDb(User user)
    {
        DbUser dbUser= new DbUser(
//                user.getId(),
                Integer.parseInt(user.getId()),
                user.getEmail(),
                user.getPassword(),
                user.getName()

                );
        return dbUser;
    }

    public User transformFromDb(DbUser dbUser)
    {
        User user = new User(
                dbUser.getId().toString(),
                dbUser.getEmail(),
                dbUser.getPassword(),
                dbUser.getName()

        );
        return user;
    }
    
}
