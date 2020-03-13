package com.example.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.datasource.db.model.DbUser;
import com.example.domain.model.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    Long InsertOnlyOne(DbUser dbUser);

    @Insert
    void InsertMultiple(List<DbUser> userList);

    @Update
    void Update(DbUser dbUser);

    // Method 2: Update by Id
    @Query(
            "UPDATE DbUser " +
                    "SET " +

                    "id = :id, " +
                    "email = :email, " +
                    "password = :password, " +
                    "name = :name " +

                    "WHERE id = :id "
    )
    void updateById(
            //<editor-fold desc="fields">

            String id,
            String email,
            String password,
            String name

            //</editor-fold>
    );

    @Delete
    void Delete(DbUser dbUser);

    // Method 2 for DELETE by query
    @Query(
            "DELETE from DbUser " +
                    "WHERE id = :id "
    )
    void deleteById(
            String id
    );

    // Method *ALL, DELETE all rows
    @Query("DELETE from DbUser")
    public void deleteAll();

    // Method... List *all
    //    public List<User> getAllUser();
    //    <-- https://www.vogella.com/tutorials/AndroidSQLite/article.html
    //    @Query("SELECT * FROM DbPet WHERE :sWhere") <-- No funcionó con "true" en sWhere
    //
    @Query("SELECT * FROM DbUser")
    List<DbUser> listAllQ();

}
