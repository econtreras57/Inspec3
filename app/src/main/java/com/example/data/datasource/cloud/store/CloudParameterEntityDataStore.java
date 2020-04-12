package com.example.data.datasource.cloud.store;

import android.content.Context;

import com.example.data.datasource.cloud.CloudInspec3Instance;
import com.example.data.datasource.cloud.dao.ParameterCloudDAO;
import com.example.data.datasource.datastore.ParameterDataStore;
import com.example.data.datasource.cloud.CloudInspec3Instance;
import com.example.data.datasource.cloud.dao.ParameterCloudDAO;
import com.example.data.datasource.cloud.model.CloudParameterEntity;
import com.example.data.mapper.ParameterDataMapper;
import com.example.domain.model.Parameter;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class CloudParameterEntityDataStore implements ParameterDataStore {

    ParameterCloudDAO parameterCloudDAO;

    public CloudParameterEntityDataStore(Context context) {
        parameterCloudDAO =
                CloudInspec3Instance.getRetrofitInstance().
                        <ParameterCloudDAO>create(ParameterCloudDAO.class);
    }

    @Override
    public void createParameter(Parameter parameter, RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        CloudParameterEntity cloudParameterEntity = parameterDataMapper.transformToCloud(parameter);

        cloudParameterEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            parameter.setId(
                    parameterCloudDAO.createParameter(cloudParameterEntity).toString()
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
            parameterCloudDAO.createParameterList(cloudParameterEntityList);     // tipos... ver domain/model/parameter
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
    public void updateParameter(Parameter parameter, RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        CloudParameterEntity cloudParameterEntity = parameterDataMapper.transformToCloud(parameter);

        cloudParameterEntity.setId(parameter.getId()); // ojo, verificar si null

        try {
            parameterCloudDAO.updateParameter(
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
    public void deleteParameter(Parameter parameter, RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        CloudParameterEntity cloudParameterEntity = parameterDataMapper.transformToCloud(parameter);

        try {
            parameterCloudDAO.deleteParameter(cloudParameterEntity.getId().toString());
            repositoryCallback.onSuccess(parameter);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void parametersList(RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
//        ParameterCloudEntity parameterCloudEntity = parameterDataMapper.transformToCloud(parameter);

        List<Parameter> parameters = new ArrayList<>();
        Parameter parameter;
        CloudParameterEntity cloudParameterEntity;


        try {
            List<CloudParameterEntity> cloudParameterEntities = parameterCloudDAO.loadParameters();

            for (int i = 0; i < cloudParameterEntities.size(); i++) {
                cloudParameterEntity = cloudParameterEntities.get(i);
                parameter = parameterDataMapper.transformFromCloud(cloudParameterEntity);
                parameters.add(parameter);
            }
            repositoryCallback.onSuccess(parameters);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

}
