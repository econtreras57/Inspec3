package com.example.data.repository;

import com.example.data.datasource.datastore.ParameterValueDataStore;
import com.example.data.datasource.datastore.ParameterValueDataStoreFactory;
import com.example.domain.model.ParameterValue;
import com.example.domain.repository.RepositoryCallback;
import com.example.domain.repository.ParameterValueRepository;
import com.example.interactor.parametervalue.ParameterValueCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueDeletedCallback;
import com.example.interactor.parametervalue.ParameterValueListCallback;
import com.example.interactor.parametervalue.ParameterValueListCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class ParameterValueDataRepository implements ParameterValueRepository {

    private final ParameterValueDataStoreFactory parameterValueDataStoreFactory;

    public ParameterValueDataRepository(
            ParameterValueDataStoreFactory parameterValueDataStoreFactory) {
        this.parameterValueDataStoreFactory = parameterValueDataStoreFactory;
    }

    @Override
    public void createParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            final ParameterValueCreatedCallback parameterValueCreatedCallback) {    // ¿final? 2020-03-12

        final ParameterValueDataStore parameterValueDataStore = parameterValueDataStoreFactory.create(
//                parameterValueDataStoreFactory.CLOUD,
                parameterValueDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterValueDataStore.createParameterValue(parameterValue, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterValueCreatedCallback.onParameterValueCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ParameterValue newParameterValue = (ParameterValue) object;
                parameterValueCreatedCallback.onParameterValueCreatedSuccess(newParameterValue);
            }
        });
    }

    @Override
    public void createParameterValueList(
            List<ParameterValue> parameterValueList,
            int parameterValueDataLocation,
            final ParameterValueListCreatedCallback parameterValueListCreateCallback) {

        final ParameterValueDataStore parameterValueDataStore = parameterValueDataStoreFactory.create(
//                parameterValueDataStoreFactory.CLOUD,
                parameterValueDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterValueDataStore.createParameterValueList(parameterValueList, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterValueListCreateCallback.onParameterValueListCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                List<ParameterValue> newParameterValueList = (List<ParameterValue>) object;
                parameterValueListCreateCallback.onParameterValueListCreatedSuccess(newParameterValueList);
            }
        });
    }

    @Override
    public void updateParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            final ParameterValueUpdatedCallback parameterValueUpdatedCallback) {

        final ParameterValueDataStore parameterValueDataStore = parameterValueDataStoreFactory.create(
//                parameterValueDataStoreFactory.CLOUD,
                parameterValueDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterValueDataStore.updateParameterValue(parameterValue, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterValueUpdatedCallback.onParameterValueUpdatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ParameterValue updParameterValue = (ParameterValue) object;
                parameterValueUpdatedCallback.onParameterValueUpdatedSuccess(updParameterValue);
            }
        });

    }

    @Override
    public void deleteParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            final ParameterValueDeletedCallback parameterValueDeletedCallback) {

        final ParameterValueDataStore parameterValueDataStore;

        parameterValueDataStore = parameterValueDataStoreFactory.create(
                parameterValueDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterValueDataStore.deleteParameterValue(parameterValue, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterValueDeletedCallback.onParameterValueDeletedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ParameterValue updParameterValue = (ParameterValue) object;
                parameterValueDeletedCallback.onParameterValueDeletedSuccess(updParameterValue);
            }
        });

    }

    @Override
    public void loadParameterValues(
            String parameterId,
            int parameterValueDataLocation,
//            final ParameterValueListCallback requestValueListCallback) {
            ParameterValueListCallback requestValueListCallback) {

//        final ParameterValueDataStore parameterValueDataStore =
        ParameterValueDataStore parameterValueDataStore =
                parameterValueDataStoreFactory.create(
                        parameterValueDataLocation
                );

        // 2020-04-17 recibir parameterId

        parameterValueDataStore.parameterValuesList(parameterId, new RepositoryCallback() {

            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                requestValueListCallback.onParameterValueListError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<ParameterValue> parameterValueArrayList = (ArrayList<ParameterValue>) object;
                requestValueListCallback.onParameterValueListSuccess(parameterValueArrayList);
            }
        });


    }

}
