package com.example.data.datasource.cloud.store;

import android.util.Log;

import com.example.common.Helper;
import com.example.data.datasource.cloud.ApiClientInterface;
import com.example.data.datasource.cloud.CloudInspec3Instance;
import com.example.data.datasource.cloud.model.ErrorWs;
import com.example.data.datasource.datastore.ParameterDataStore;
import com.example.data.datasource.cloud.model.CloudParameterEntity;
import com.example.data.mapper.ParameterDataMapper;
import com.example.domain.model.Parameter;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CloudParameterEntityDataStore
        implements ParameterDataStore {

    private static final String TAG = "CloudParameterEntityDat";
    ApiClientInterface apiClientInterface;

    public CloudParameterEntityDataStore() {
        apiClientInterface = CloudInspec3Instance.getApiClient();
    }

    @Override
    public void createParameter(
            Parameter parameter,
            RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        CloudParameterEntity cloudParameterEntity =
                parameterDataMapper.transformToCloud(parameter);

        cloudParameterEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            parameter.setId(
                    apiClientInterface.createParameter(cloudParameterEntity).toString()
            );
            repositoryCallback.onSuccess(parameter);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void createParameterList(
            List<Parameter> parameterList,
            RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
//        ParameterCloudEntity parameterCloudEntity=parameterDataMapper.transformToCloud(parameter);

        List<CloudParameterEntity> cloudParameterEntityList = new ArrayList<>();
        for (int i = 0; i < parameterList.size(); i++) {
            Parameter wrkParameter = parameterList.get(i);
            CloudParameterEntity wrkCloudParameterEntity = parameterDataMapper.transformToCloud(wrkParameter);
            wrkCloudParameterEntity.setId(null);     // para que se creen automáticamente
            cloudParameterEntityList.add(wrkCloudParameterEntity);
        }

//        parameterCloudEntity.setId( 0 ); // o null?

        try {
            apiClientInterface.createParameterList(cloudParameterEntityList);     // tipos... ver domain/model/parameter
            repositoryCallback.onSuccess(parameterList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void getParameter(
            Parameter parameter,
            RepositoryCallback repositoryCallback) {

        // ToDo

    }

    @Override
    public void updateParameter(
            Parameter parameter,
            RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        CloudParameterEntity cloudParameterEntity = parameterDataMapper.transformToCloud(parameter);

        cloudParameterEntity.setId(parameter.getId()); // ojo, verificar si null

        try {
            apiClientInterface.updateParameter(
                    cloudParameterEntity.getId(),
                    cloudParameterEntity   // aquí el "body"
            );
            repositoryCallback.onSuccess(parameter);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void deleteParameter(
            Parameter parameter,
            RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper =
                new ParameterDataMapper();
        CloudParameterEntity cloudParameterEntity =
                parameterDataMapper.transformToCloud(parameter);

        try {
            apiClientInterface.deleteParameter(cloudParameterEntity.getId().toString());
            repositoryCallback.onSuccess(parameter);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void parametersList(final RepositoryCallback repositoryCallback) {

        try {
            Call<List<CloudParameterEntity>> call =
                    apiClientInterface.loadParameters();
            call.enqueue(new Callback<List<CloudParameterEntity>>() {
                @Override
                public void onResponse(
                        Call<List<CloudParameterEntity>> call,
                        Response<List<CloudParameterEntity>> response) {
                    if (response.isSuccessful()) {
                        List<CloudParameterEntity> bodyResponse =
                                response.body();
                        repositoryCallback.onSuccess(bodyResponse);
                    } else {
                        ErrorWs error = Helper.getWsErrorResponse(response);
                        repositoryCallback.onError(error.getMessage());
                    }
                }

                @Override
                public void onFailure(
                        Call<List<CloudParameterEntity>> call,
                        Throwable t) {
                    String message = "";
                    if (t != null) {
                        message = t.getMessage();
                    }
                    Log.i(TAG, "error " + message);
                    repositoryCallback.onError(message);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

}
