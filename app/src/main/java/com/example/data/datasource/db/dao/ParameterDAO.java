package com.example.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.datasource.db.model.ParameterDbEntity;

import java.util.List;

@Dao
public interface ParameterDAO {

    @Insert
    Long InsertOnlyOne(ParameterDbEntity parameterDbEntity);

    @Insert
    void InsertMultiple(List<ParameterDbEntity> parameterDbEntityList);

    @Update
    void Update(ParameterDbEntity parameterDbEntity);

    @Delete
    void Delete(ParameterDbEntity parameterDbEntity);

    // Method 2 for DELETE by query
    @Query(
            "DELETE from ParameterDbEntity " +
                    "WHERE id = :id "
    )
    void deleteById(
            String id
    );

    // Method *ALL, DELETE all rows
    @Query("DELETE from ParameterDbEntity")
    public void deleteAll();

    // Method... List *all
    //    public List<User> getAllUser();
    //    <-- https://www.vogella.com/tutorials/AndroidSQLite/article.html
    //    @Query("SELECT * FROM DbPet WHERE :sWhere") <-- No funcionó con "true" en sWhere
    //
    @Query("SELECT * FROM ParameterDbEntity")
    List<ParameterDbEntity> listAllQ();


    // Method 2: Update by Id
    @Query(
            "UPDATE ParameterDbEntity " +
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


}
