package com.example.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.datasource.db.model.ParameterValueDbEntity;

import java.util.List;

@Dao
public interface ParameterValueDAO {

    @Insert
    Long InsertOnlyOne(ParameterValueDbEntity parameterValueDbEntity);

    @Insert
    void InsertMultiple(List<ParameterValueDbEntity> parameterValueDbEntityList);

    @Update
    void Update(ParameterValueDbEntity parameterValueDbEntity);

    @Delete
    void Delete(ParameterValueDbEntity parameterValueDbEntity);

    // Method 2 for DELETE by query
    @Query(
            "DELETE from ParameterValueDbEntity " +
                    "WHERE id = :id "
    )
    void deleteById(
            String id
    );

    // Method *ALL, DELETE all rows
    @Query("DELETE from ParameterValueDbEntity")
    public void deleteAll();

    // Method... List *all
    //    public List<User> getAllUser();
    //    <-- https://www.vogella.com/tutorials/AndroidSQLite/article.html
    //    @Query("SELECT * FROM DbPet WHERE :sWhere") <-- No funcionó con "true" en sWhere
    //
    @Query("SELECT * FROM ParameterValueDbEntity")
    List<ParameterValueDbEntity> listAllQ();


    // Method 2: Update by Id
    @Query(
            "UPDATE ParameterValueDbEntity " +
                    "SET " +

                    "id = :id, " +
                    "idParameter = :idParameter, " +
                    "idParameterValueSuperior = :idParameterValueSuperior, " +
                    "name = :name, " +
                    "value = :value, " +
                    "valueFull = :valueFull, " +
                    "valueAdditional1 = :valueAdditional1, " +
                    "valueAdditional2 = :valueAdditional2, " +
                    "valueAdditional3 = :valueAdditional3, " +
                    "`order` = :order, " +
                    "enable = :enable, " +
                    "idUserRegister = :idUserRegister, " +
                    "idUserModify = :idUserModify, " +
                    "dateRegister = :dateRegister, " +
                    "dateModify = :dateModify, " +
                    "deleted = :deleted " +

                    "WHERE id = :id "
    )
    void updateById(
            //<editor-fold desc="fields">

            String id,
            String idParameter,
            String idParameterValueSuperior,
            String name,
            String value,
            String valueFull,
            String valueAdditional1,
            String valueAdditional2,
            String valueAdditional3,
            String order,
            String enable,
            String idUserRegister,
            String idUserModify,
            String dateRegister,
            String dateModify,
            String deleted

            //</editor-fold>
    );


}
