package com.example.data.datasource.datastore;

import android.content.Context;

import com.example.data.datasource.db.store.DbFindingsDataStore;

public class FindingsDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;

    private final Context context;

    public FindingsDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }

    public FindingsDataStore create(
//            int dataSource, FirebaseFirestore db) {
            int dataSource) {

        FindingsDataStore findingsDataStore = null;

        switch (dataSource) {
            case CLOUD:
//                findingsDataStore = createCloudDataStore(db);
                break;
            case DB:
                findingsDataStore = new DbFindingsDataStore(context);
                break;
        }
        return findingsDataStore;
    }

//    private FindingsDataStore createCloudDataStore(
//            FirebaseFirestore db) {
//        return new CloudFindingsDataStore(db);
//    }


}
