package com.example.data.datasource.datastore;

import android.content.Context;

import com.example.data.datasource.db.store.DbInspectionDataStore;

public class InspectionDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;

    private final Context context;

    public InspectionDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }

    public InspectionDataStore create(
//            int dataSource, FirebaseFirestore db) {
            int dataSource) {

        InspectionDataStore inspectionDataStore = null;

        switch (dataSource) {
            case CLOUD:
//                inspectionDataStore = createCloudDataStore(db);
                break;
            case DB:
                inspectionDataStore = new DbInspectionDataStore(context);
                break;
        }
        return inspectionDataStore;
    }

//    private InspectionDataStore createCloudDataStore(
//            FirebaseFirestore db) {
//        return new CloudInspectionDataStore(db);
//    }


}
