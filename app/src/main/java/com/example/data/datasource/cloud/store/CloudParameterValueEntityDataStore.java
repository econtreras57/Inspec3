package com.example.data.datasource.cloud.store;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.common.Helper;
import com.example.data.datasource.cloud.ApiClientInterface;
import com.example.data.datasource.cloud.CloudInspec3Instance;
import com.example.data.datasource.cloud.model.CloudParameterEntity;
import com.example.data.datasource.cloud.model.CloudParameterValueEntity;
import com.example.data.datasource.cloud.model.ErrorWs;
import com.example.data.datasource.datastore.ParameterValueDataStore;
import com.example.data.datasource.db.DbInspec3Instance;
import com.example.data.datasource.db.dao.ParameterValueDAO;
import com.example.data.mapper.ParameterValueDataMapper;
import com.example.domain.model.Parameter;
import com.example.domain.model.ParameterValue;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CloudParameterValueEntityDataStore
        implements ParameterValueDataStore {

    private static final String TAG = "CloudParameterValueEntityDataStore";
    ApiClientInterface apiClientInterface;

    public CloudParameterValueEntityDataStore() {
        apiClientInterface = CloudInspec3Instance.getApiClient();
    }

    @Override
    public void createParameterValue(
            ParameterValue parameterValue,
            RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper =
                new ParameterValueDataMapper();
        CloudParameterValueEntity cloudParameterValueEntity =
                parameterValueDataMapper.transformToCloud(parameterValue);

        cloudParameterValueEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            parameterValue.setId(
                    apiClientInterface.createParameterValue(cloudParameterValueEntity).toString()
            );
            repositoryCallback.onSuccess(parameterValue);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void createParameterValueList(
            List<ParameterValue> parameterValueList,
            RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
//        ParameterValueDbEntity parameterValueDbEntity=parameterValueDataMapper.transformToDb(parameterValue);

        List<CloudParameterValueEntity> cloudParameterValueEntityList = new ArrayList<>();
        for (int i = 0; i < parameterValueList.size(); i++) {
            ParameterValue wrkParameterValue = parameterValueList.get(i);
            CloudParameterValueEntity wrkCloudParameterValueEntity = parameterValueDataMapper.transformToCloud(wrkParameterValue);
            wrkCloudParameterValueEntity.setId(null);     // para que se creen automáticamente
            cloudParameterValueEntityList.add(wrkCloudParameterValueEntity);
        }

//        parameterValueDbEntity.setId( 0 ); // o null?

        try {
            apiClientInterface.createParameterValueList(cloudParameterValueEntityList);     // tipos... ver domain/model/parameterValue
            repositoryCallback.onSuccess(parameterValueList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateParameterValue(
            ParameterValue parameterValue,
            RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
        CloudParameterValueEntity cloudParameterValueEntity =
                parameterValueDataMapper.transformToCloud(parameterValue);

        cloudParameterValueEntity.setId(parameterValue.getId()); // ojo, verificar si null

        try {
            apiClientInterface.updateParameterValue(
                    cloudParameterValueEntity.getId(),
                    cloudParameterValueEntity
            );
            repositoryCallback.onSuccess(parameterValue);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void deleteParameterValue(
            ParameterValue parameterValue,
            RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper =
                new ParameterValueDataMapper();
        CloudParameterValueEntity cloudParameterValueEntity =
                parameterValueDataMapper.transformToCloud(parameterValue);

        try {
            apiClientInterface.deleteParameterValue(cloudParameterValueEntity.getId().toString());
            repositoryCallback.onSuccess(parameterValue);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void parameterValuesList(
            String parameterId,
            RepositoryCallback repositoryCallback) {

        Call<List<CloudParameterValueEntity>> call =
                apiClientInterface.getListParameterValues(parameterId);

        Callback<List<CloudParameterValueEntity>> listCallback =
                new Callback<List<CloudParameterValueEntity>>() {

                    @Override
                    public void onResponse(Call<List<CloudParameterValueEntity>> call,
                                           Response<List<CloudParameterValueEntity>> response) {
                        if (response.isSuccessful()) {
                            List<CloudParameterValueEntity> bodyResponse = response.body();
                            repositoryCallback.onSuccess(bodyResponse);
                        } else {
                            ErrorWs error = Helper.getWsErrorResponse(response);
                            repositoryCallback.onError(error.getMessage());
                        }
                        Log.i(TAG, "onResponse isSuccessful? " +
                                String.valueOf(response.isSuccessful()) +
                                response.toString()
                        );   // onResponse?
                    }

                    @Override
                    public void onFailure(Call<List<CloudParameterValueEntity>> call,
                                          Throwable t) {
                        String message = "";
                        if (t != null) {
                            message = t.getMessage();
                        }
                        Log.i(TAG, "onFailure: " + message);
                        repositoryCallback.onError(message);

                    }
                };

        Call<List<CloudParameterValueEntity>> callClone = call.clone();
        try {
            callClone.enqueue(listCallback);
// 2020-05-13 Probemos por ahora una llamada sync (.execute()) <-- nop, no func en Activity
//            Response<List<CloudParameterValueEntity>> response = callClone.execute();
//            List<CloudParameterValueEntity> bodyResponse = response.body();
//            repositoryCallback.onSuccess(bodyResponse);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

}
