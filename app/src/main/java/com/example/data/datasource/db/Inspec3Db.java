package com.example.data.datasource.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.data.datasource.db.dao.FindingsDAO;
import com.example.data.datasource.db.dao.InspectionDAO;
import com.example.data.datasource.db.dao.ParameterDAO;
import com.example.data.datasource.db.dao.ParameterValueDAO;
import com.example.data.datasource.db.dao.SessionDAO;
import com.example.data.datasource.db.dao.UserDAO;
import com.example.data.datasource.db.model.DbFindings;
import com.example.data.datasource.db.model.DbInspection;
import com.example.data.datasource.db.model.DbUser;
import com.example.data.datasource.db.model.ParameterDbEntity;
import com.example.data.datasource.db.model.ParameterValueDbEntity;
import com.example.data.datasource.db.model.SessionDbEntity;
import com.example.domain.model.Findings;
import com.example.domain.model.Inspection;
import com.example.domain.model.Parameter;
import com.example.domain.model.ParameterValue;
import com.example.domain.model.Session;
import com.example.domain.model.User;
import com.example.presentation.utils.Converters;


@Database(entities = {
        DbUser.class,
        DbInspection.class,
        DbFindings.class,
        ParameterDbEntity.class,
        ParameterValueDbEntity.class,
        SessionDbEntity.class,

        Findings.class,
        Inspection.class,
        Session.class,
        Parameter.class,
        ParameterValue.class,
        User.class
},
        version = 1,
        exportSchema = false) // <-- ** version **

@TypeConverters({Converters.class}) // 2020-03-13 ecv: Según manual, para manejo type Date

public abstract class Inspec3Db extends RoomDatabase {

    private static Inspec3Db INSTANCE;
    private static final String DB_NAME = "Inspec3.db";
    private static Context mContext;

    public static Inspec3Db getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Inspec3Db.class) {
                if (INSTANCE == null) {
                    mContext = context.getApplicationContext();
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Inspec3Db.class, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    // Log.i(TAG, "populating with data...");
//                                    new PopulateDbAsync(INSTANCE).execute();
                                }
                            }).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UserDAO userDAO();

    public abstract InspectionDAO inspectionDAO();

    public abstract FindingsDAO findingsDAO();

    public abstract SessionDAO sessionDAO();

    public abstract ParameterDAO parameterDAO();

    public abstract ParameterValueDAO parameterValueDAO();

}