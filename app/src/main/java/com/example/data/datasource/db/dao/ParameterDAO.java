package com.example.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.datasource.db.model.DbParameterEntity;

import java.util.List;

@Dao
public interface ParameterDAO {

    // Create one
    @Insert
    Long InsertOnlyOne(DbParameterEntity dbParameterEntity);

    // Create batch
    @Insert
    void InsertMultiple(List<DbParameterEntity> dbParameterEntityList);

    // Read one
    @Query("SELECT * FROM DbParameterEntity " +
            "WHERE id = :id ")
    DbParameterEntity readOnlyOne(
            String id
    );

    // Read all
    // Method... List *all
    //    public List<User> getAllUser();
    //    <-- https://www.vogella.com/tutorials/AndroidSQLite/article.html
    //    @Query("SELECT * FROM DbPet WHERE :sWhere") <-- No funcionó con "true" en sWhere
    //
    @Query("SELECT * FROM DbParameterEntity")
    List<DbParameterEntity> listAllQ();

    // Update one
    @Update
    void Update(DbParameterEntity dbParameterEntity);

    // Udate one; Method 2: Update by Id
    @Query(
            "UPDATE DbParameterEntity " +
                    "SET " +

                    "id = :id, " +
                    "name = :name, " +
                    "idParameterSuperior = :idParameterSuperior, " +
                    "canShow = :canShow, " +
                    "canAdd = :canAdd, " +
                    "canDisabled = :canDisabled, " +
                    "canEdit = :canEdit, " +
                    "canDeleted = :canDeleted, " +
                    "additional1 = :additional1, " +
                    "additional2 = :additional2, " +
                    "additional3 = :additional3, " +
                    "deleted = :deleted " +

                    "WHERE id = :id "
    )
    void updateById(
            //<editor-fold desc="fields">

            String id,
            String name,
            String idParameterSuperior,
            String canShow,
            String canAdd,
            String canDisabled,
            String canEdit,
            String canDeleted,
            String additional1,
            String additional2,
            String additional3,
            String deleted

            //</editor-fold>
    );

    // Delete one
    @Delete
    void Delete(DbParameterEntity dbParameterEntity);

    // Delete one. Method 2 for DELETE by query
    @Query(
            "DELETE from DbParameterEntity " +
                    "WHERE id = :id "
    )
    void deleteById(
            String id
    );

    // Delete *ALL. Method *ALL, DELETE all rows
    @Query("DELETE from DbParameterEntity")
    public void deleteAll();

}
