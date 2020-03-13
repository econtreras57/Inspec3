package com.example.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.datasource.db.model.DbInspection;

import java.util.List;

@Dao
public interface InspectionDAO {

    @Insert
    Long InsertOnlyOne(DbInspection dbInspection);

    @Insert
    void InsertMultiple(List<DbInspection> userList);

    @Update
    void Update(DbInspection dbInspection);

    // Method 2: Update by Id
    @Query(
            "UPDATE DbInspection " +
                    "SET " +

                    "id = :id, " +
                    "inspector = :inspector, " +
                    "date = :date, " +
                    "statusDate = :statusDate, " +
                    "status = :status, " +
                    "subStatusDate = :subStatusDate, " +
                    "subStatus = :subStatus, " +
                    "planned = :planned, " +
                    "project = :project, " +
                    "contractor = :contractor, " +
                    "locType = :locType, " +
                    "site = :site, " +
                    "responsible = :responsible " +

                    "WHERE id = :id "
    )
    void updateById(
            //<editor-fold desc="fields">

            String id,
            String inspector,
            String date,
            String statusDate,
            String status,
            String subStatusDate,
            String subStatus,
            String planned,
            String project,
            String contractor,
            String locType,
            String site,
            String responsible

            //</editor-fold>
    );

    @Delete
    void Delete(DbInspection dbInspection);

    // Method 2 for DELETE by query
    @Query(
            "DELETE from DbInspection " +
                    "WHERE id = :id "
    )
    void deleteById(
            String id
    );

    // Method *ALL, DELETE all rows
    @Query("DELETE from DbInspection")
    public void deleteAll();

    // Method... List *all
    //    public List<User> getAllUser();
    //    <-- https://www.vogella.com/tutorials/AndroidSQLite/article.html
    //    @Query("SELECT * FROM DbPet WHERE :sWhere") <-- No funcionó con "true" en sWhere
    //
    @Query("SELECT * FROM DbInspection")
    List<DbInspection> listAllQ();


}
