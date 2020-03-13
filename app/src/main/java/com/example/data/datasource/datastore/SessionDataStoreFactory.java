package com.example.data.datasource.datastore;

import android.content.Context;

import com.example.data.datasource.db.store.SessionDbEntityDataStore;

public class SessionDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;

    private final Context context;

    public SessionDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }

    public SessionDataStore create(
//            int dataSource, FirebaseFirestore db) {
            int dataSource) {

        SessionDataStore sessionDataStore = null;

        switch (dataSource) {
            case CLOUD:
//                sessionDataStore = createCloudDataStore(db);
                break;
            case DB:
                sessionDataStore = new SessionDbEntityDataStore(context);
                break;
        }
        return sessionDataStore;
    }

//    private SessionDataStore createCloudDataStore(
//            FirebaseFirestore db) {
//        return new CloudSessionDataStore(db);
//    }

}
