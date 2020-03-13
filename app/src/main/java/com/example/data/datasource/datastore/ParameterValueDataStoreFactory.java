package com.example.data.datasource.datastore;

import android.content.Context;

import com.example.data.datasource.db.store.ParameterValueDbEntityDataStore;

public class ParameterValueDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;

    private final Context context;

    public ParameterValueDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }

    public ParameterValueDataStore create(
//            int dataSource, FirebaseFirestore db) {
            int dataSource) {

        ParameterValueDataStore parameterValueDataStore = null;

        switch (dataSource) {
            case CLOUD:
//                parameterValueDataStore = createCloudDataStore(db);
                break;
            case DB:
                parameterValueDataStore = new ParameterValueDbEntityDataStore(context);
                break;
        }
        return parameterValueDataStore;
    }

//    private ParameterValueDataStore createCloudDataStore(
//            FirebaseFirestore db) {
//        return new CloudParameterValueDataStore(db);
//    }

}
