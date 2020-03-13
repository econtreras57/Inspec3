package com.example.data.datasource.datastore;

import android.content.Context;

import com.example.data.datasource.db.store.DbUserDataStore;

public class UserDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;

    private final Context context;

    public UserDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }

    public UserDataStore create(
//            int dataSource, FirebaseFirestore db) {
            int dataSource) {

        UserDataStore userDataStore = null;

        switch (dataSource) {
            case CLOUD:
//                userDataStore = createCloudDataStore(db);
                break;
            case DB:
                userDataStore = new DbUserDataStore(context);
                break;
        }
        return userDataStore;
    }

//    private UserDataStore createCloudDataStore(
//            FirebaseFirestore db) {
//        return new CloudUserDataStore(db);
//    }

}
