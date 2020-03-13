package com.example.data.datasource.datastore;

import android.content.Context;

import com.example.data.datasource.db.store.ParameterDbEntityDataStore;

public class ParameterDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;

    private final Context context;

    public ParameterDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }

    public ParameterDataStore create(
//            int dataSource, FirebaseFirestore db) {
            int dataSource) {

        ParameterDataStore parameterDataStore = null;

        switch (dataSource) {
            case CLOUD:
//                parameterDataStore = createCloudDataStore(db);
                break;
            case DB:
                parameterDataStore = new ParameterDbEntityDataStore(context);
                break;
        }
        return parameterDataStore;
    }

//    private ParameterDataStore createCloudDataStore(
//            FirebaseFirestore db) {
//        return new CloudParameterDataStore(db);
//    }

}
