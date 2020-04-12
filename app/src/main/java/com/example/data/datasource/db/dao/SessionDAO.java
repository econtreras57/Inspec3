package com.example.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.datasource.db.model.DbSessionEntity;

import java.util.List;

@Dao
public interface SessionDAO {

    @Insert
    Long InsertOnlyOne(DbSessionEntity dbSessionEntity);

    @Insert
    void InsertMultiple(List<DbSessionEntity> dbSessionEntityList);

    @Update
    void Update(DbSessionEntity dbSessionEntity);

    @Delete
    void Delete(DbSessionEntity dbSessionEntity);

    // Method 2 for DELETE by query
    @Query(
            "DELETE from DbSessionEntity " +
                    "WHERE id = :id "
    )
    void deleteById(
            String id
    );

    // Method *ALL, DELETE all rows
    @Query("DELETE from DbSessionEntity")
    public void deleteAll();

    // Method... List *all
    //    public List<User> getAllUser();
    //    <-- https://www.vogella.com/tutorials/AndroidSQLite/article.html
    //    @Query("SELECT * FROM DbPet WHERE :sWhere") <-- No funcionó con "true" en sWhere
    //
    @Query("SELECT * FROM DbSessionEntity")
    List<DbSessionEntity> listAllQ();


    // Method 2: Update by Id
    @Query(
            "UPDATE DbSessionEntity " +
                    "SET " +

                    "id = :id, " +
                    "username = :username, " +
                    "mail = :mail, " +
                    "name = :name, " +
                    "lastName = :lastName, " +
                    "fullName = :fullName, " +
                    "authDate = :authDate, " +
                    "lastAuthDate = :lastAuthDate, " +
                    "lastSyncDatePush = :lastSyncDatePush, " +
                    "lastSyncDatePull = :lastSyncDatePull, " +
                    "token = :token, " +
                    "idWarehouse = :idWarehouse, " +
                    "idCounting = :idCounting, " +
                    "idInventory = :idInventory, " +
                    "idInventoryCountingWarehouse = :idInventoryCountingWarehouse " +

                    "WHERE id = :id "
    )
    void updateById(
            //<editor-fold desc="fields">

            String id,
            String username,
            String mail,
            String name,
            String lastName,
            String fullName,
            String authDate,
            String lastAuthDate,
            String lastSyncDatePush,
            String lastSyncDatePull,
            String token,
            String idWarehouse,
            String idCounting,
            String idInventory,
            String idInventoryCountingWarehouse

            //</editor-fold>
    );


}
