package com.example.data.datasource.datastore;

import android.content.Context;

import com.example.data.datasource.cloud.model.CloudParameterValueEntity;
import com.example.data.datasource.cloud.store.CloudParameterValueEntityDataStore;
import com.example.data.datasource.db.store.DbParameterValueEntityDataStore;

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

    public ParameterValueDataStore create(int dataSource) {

        ParameterValueDataStore parameterValueDataStore = null;

        switch (dataSource) {
            case CLOUD:
                parameterValueDataStore = createCloudDataStore();
                break;
            case DB:
                parameterValueDataStore = new DbParameterValueEntityDataStore(context);
                break;
        }
        return parameterValueDataStore;
    }

    private ParameterValueDataStore createCloudDataStore() {
        return new CloudParameterValueEntityDataStore();
    }

}
