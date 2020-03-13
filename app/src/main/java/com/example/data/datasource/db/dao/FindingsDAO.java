package com.example.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.datasource.db.model.DbFindings;

import java.util.List;

@Dao
public interface FindingsDAO {

    @Insert
    Long InsertOnlyOne(DbFindings dbFindings);

    @Insert
    void InsertMultiple(List<DbFindings> userList);

    @Update
    void Update(DbFindings dbFindings);

    @Delete
    void Delete(DbFindings dbFindings);

    // Method 2 for DELETE by query
    @Query(
            "DELETE from DbFindings " +
                    "WHERE id = :id "
    )
    void deleteById(
            String id
    );

    // Method *ALL, DELETE all rows
    @Query("DELETE from DbFindings")
    public void deleteAll();

    // Method... List *all
    //    public List<User> getAllUser();
    //    <-- https://www.vogella.com/tutorials/AndroidSQLite/article.html
    //    @Query("SELECT * FROM DbPet WHERE :sWhere") <-- No funcionó con "true" en sWhere
    //
    @Query("SELECT * FROM DbFindings")
    List<DbFindings> listAllQ();


    // Method 2: Update by Id
    @Query(
            "UPDATE DbFindings " +
                    "SET " +

                    "id = :id, " +
                    "inspectionId = :inspectionId, " +
                    "type = :type, " +
                    "subType = :subType, " +
                    "management = :management, " +
                    "text = :text, " +
                    "photo_1 = :photo_1, " +
                    "photo_2 = :photo_2, " +
                    "riskLevel = :riskLevel, " +
                    "date = :date, " +
                    "statusDate = :statusDate, " +
                    "plannedClosureDate = :plannedClosureDate, " +
                    "status = :status " +

                    "WHERE id = :id "
    )
    void updateById(
            //<editor-fold desc="fields">

            String id,
            String inspectionId,
            String type,
            String subType,
            String management,
            String text,
            String photo_1,
            String photo_2,
            String riskLevel,
            String date,
            String statusDate,
            String plannedClosureDate,
            String status

            //</editor-fold>
    );


}
