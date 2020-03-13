package com.example.data.datasource.db.store;

import android.content.Context;

import com.example.data.datasource.datastore.ParameterDataStore;
import com.example.data.datasource.db.Inspec3Db;
import com.example.data.datasource.db.dao.ParameterDAO;
import com.example.data.datasource.db.model.ParameterDbEntity;
import com.example.data.mapper.ParameterDataMapper;
import com.example.domain.model.Parameter;
import com.example.domain.repository.RepositoryCallback;
import com.mapbox.mapboxsdk.plugins.annotation.OnSymbolLongClickListener;

import java.util.ArrayList;
import java.util.List;

public class ParameterDbEntityDataStore implements ParameterDataStore {

    ParameterDAO parameterDAO;

    public ParameterDbEntityDataStore(Context context) {
        parameterDAO = Inspec3Db.getDatabase(context).parameterDAO();
    }

    @Override
    public void createParameter(Parameter parameter, RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        ParameterDbEntity parameterDbEntity = parameterDataMapper.transformToDb(parameter);

        parameterDbEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            parameter.setId(
                    parameterDAO.InsertOnlyOne(parameterDbEntity).toString()
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
//        ParameterDbEntity parameterDbEntity=parameterDataMapper.transformToDb(parameter);

        List<ParameterDbEntity> parameterDbEntityList = new ArrayList<>();
        for (int i = 0; i < parameterList.size(); i++) {
            Parameter wrkParameter = parameterList.get(i);
            ParameterDbEntity wrkParameterDbEntity = parameterDataMapper.transformToDb(wrkParameter);
            wrkParameterDbEntity.setId(null);     // para que se creen automáticamente
            parameterDbEntityList.add(wrkParameterDbEntity);
        }

//        parameterDbEntity.setId( 0 ); // o null?

        try {
            parameterDAO.InsertMultiple(parameterDbEntityList);     // tipos... ver domain/model/parameter
            repositoryCallback.onSuccess(parameterList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateParameter(Parameter parameter, RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        ParameterDbEntity parameterDbEntity = parameterDataMapper.transformToDb(parameter);

        parameterDbEntity.setId(parameter.getId()); // ojo, verificar si null

        try {
            parameterDAO.updateById(
                    parameterDbEntity.getId(),
                    parameterDbEntity.getName(),
                    parameterDbEntity.getIdParameterSuperior(),
                    Boolean.toString(parameterDbEntity.isCanShow()),
                    Boolean.toString(parameterDbEntity.isCanAdd()),
                    Boolean.toString(parameterDbEntity.isCanDisabled()),
                    Boolean.toString(parameterDbEntity.isCanEdit()),
                    Boolean.toString(parameterDbEntity.isCanDeleted()),
                    parameterDbEntity.getAdditional1(),
                    parameterDbEntity.getAdditional2(),
                    parameterDbEntity.getAdditional3(),
                    Boolean.toString(parameterDbEntity.isDeleted())

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
        ParameterDbEntity parameterDbEntity = parameterDataMapper.transformToDb(parameter);

        try {
            if (parameterDbEntity.getName().equalsIgnoreCase("delete*ALL")) {
                parameterDAO.deleteAll();
            } else {
                parameterDAO.deleteById(parameterDbEntity.getId().toString());
            }
            repositoryCallback.onSuccess(parameter);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void parametersList(RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
//        ParameterDbEntity parameterDbEntity = parameterDataMapper.transformToDb(parameter);

        List<Parameter> parameters = new ArrayList<>();
        Parameter parameter;
        ParameterDbEntity parameterDbEntity;

        try {
            List<ParameterDbEntity> parameterDbEntitys = parameterDAO.listAllQ();

            for (int i = 0; i < parameterDbEntitys.size(); i++) {
                parameterDbEntity = parameterDbEntitys.get(i);
                parameter = parameterDataMapper.transformFromDb(parameterDbEntity);
                parameters.add(parameter);
            }
            repositoryCallback.onSuccess(parameters);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

}
