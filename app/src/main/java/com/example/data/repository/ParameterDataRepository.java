package com.example.data.repository;

import com.example.data.datasource.datastore.ParameterDataStore;
import com.example.data.datasource.datastore.ParameterDataStoreFactory;
import com.example.domain.model.Parameter;
import com.example.domain.repository.RepositoryCallback;
import com.example.domain.repository.ParameterRepository;
import com.example.interactor.parameter.ParameterCreatedCallback;
import com.example.interactor.parameter.ParameterDeletedCallback;
import com.example.interactor.parameter.ParameterListCallback;
import com.example.interactor.parameter.ParameterListCreatedCallback;
import com.example.interactor.parameter.ParameterUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class ParameterDataRepository implements ParameterRepository {

    private final ParameterDataStoreFactory parameterDataStoreFactory;

    public ParameterDataRepository(
            ParameterDataStoreFactory parameterDataStoreFactory) {
        this.parameterDataStoreFactory = parameterDataStoreFactory;
    }

    @Override
    public void createParameter(
            Parameter parameter,
            int parameterDataLocation,
            final ParameterCreatedCallback parameterCreatedCallback) {    // ¿final? 2020-03-12

        final ParameterDataStore parameterDataStore = parameterDataStoreFactory.create(
//                parameterDataStoreFactory.CLOUD,
                parameterDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterDataStore.createParameter(parameter, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterCreatedCallback.onParameterCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Parameter newParameter = (Parameter) object;
                parameterCreatedCallback.onParameterCreatedSuccess(newParameter);
            }
        });
    }

    @Override
    public void createParameterList(
            List<Parameter> parameterList,
            int parameterDataLocation,
            final ParameterListCreatedCallback parameterListCreateCallback) {

        final ParameterDataStore parameterDataStore = parameterDataStoreFactory.create(
//                parameterDataStoreFactory.CLOUD,
                parameterDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterDataStore.createParameterList(parameterList, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterListCreateCallback.onParameterListCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                List<Parameter> newParameterList = (List<Parameter>) object;
                parameterListCreateCallback.onParameterListCreatedSuccess(newParameterList);
            }
        });
    }

    @Override
    public void getParameter(
            Parameter parameter,
            int parameterDataLocation,
            final ParameterListCallback requestListCallback) {

        // ToDo

    }

    @Override
    public void updateParameter(
            Parameter parameter,
            int parameterDataLocation,
            final ParameterUpdatedCallback parameterUpdatedCallback) {

        final ParameterDataStore parameterDataStore = parameterDataStoreFactory.create(
//                parameterDataStoreFactory.CLOUD,
                parameterDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterDataStore.updateParameter(parameter, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterUpdatedCallback.onParameterUpdatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Parameter updParameter = (Parameter) object;
                parameterUpdatedCallback.onParameterUpdatedSuccess(updParameter);
            }
        });

    }

    @Override
    public void deleteParameter(
            Parameter parameter,
            int parameterDataLocation,
            final ParameterDeletedCallback parameterDeletedCallback) {

        final ParameterDataStore parameterDataStore;

        parameterDataStore = parameterDataStoreFactory.create(
                parameterDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterDataStore.deleteParameter(parameter, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                parameterDeletedCallback.onParameterDeletedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Parameter updParameter = (Parameter) object;
                parameterDeletedCallback.onParameterDeletedSuccess(updParameter);
            }
        });

    }

    @Override
    public void loadParameters(
            int parameterDataLocation,
            final ParameterListCallback requestListCallback) {

        final ParameterDataStore parameterDataStore = parameterDataStoreFactory.create(
//                parameterDataStoreFactory.CLOUD, FirebaseFirestore.getInstance());
                parameterDataLocation
//                FirebaseFirestore.getInstance()
        );

        parameterDataStore.parametersList(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                requestListCallback.onParameterListError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<Parameter> parameterArrayList = (ArrayList<Parameter>) object;
                requestListCallback.onParameterListSuccess(parameterArrayList);
            }
        });


    }

}
