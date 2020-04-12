package com.example.data.datasource.db.store;

import android.content.Context;

import com.example.data.datasource.datastore.ParameterDataStore;
import com.example.data.datasource.db.DbInspec3Instance;
import com.example.data.datasource.db.dao.ParameterDAO;
import com.example.data.datasource.db.model.DbParameterEntity;
import com.example.data.mapper.ParameterDataMapper;
import com.example.domain.model.Parameter;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

public class DbParameterEntityDataStore implements ParameterDataStore {

    ParameterDAO parameterDAO;

    public DbParameterEntityDataStore(Context context) {
        parameterDAO = DbInspec3Instance.getDatabase(context).parameterDAO();
    }

    @Override
    public void createParameter(Parameter parameter, RepositoryCallback repositoryCallback) {

        ParameterDataMapper parameterDataMapper = new ParameterDataMapper();
        DbParameterEntity dbParameterEntity = parameterDataMapper.transformToDb(parameter);

        dbParameterEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            parameter.setId(
                    parameterDAO.InsertOnlyOne(dbParameterEntity).toString()
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

        List<DbParameterEntity> dbParameterEntityList = new ArrayList<>();
        for (int i = 0; i < parameterList.size(); i++) {
            Parameter wrkParameter = parameterList.get(i);
            DbParameterEntity wrkDbParameterEntity = parameterDataMapper.transformToDb(wrkParameter);
            wrkDbParameterEntity.setId(null);     // para que se creen automáticamente
            dbParameterEntityList.add(wrkDbParameterEntity);
        }

//        parameterDbEntity.setId( 0 ); // o null?

        try {
            parameterDAO.InsertMultiple(dbParameterEntityList);     // tipos... ver domain/model/parameter
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
        DbParameterEntity dbParameterEntity = parameterDataMapper.transformToDb(parameter);

        dbParameterEntity.setId(parameter.getId()); // ojo, verificar si null

        try {
            parameterDAO.updateById(
                    dbParameterEntity.getId(),
                    dbParameterEntity.getName(),
                    dbParameterEntity.getIdParameterSuperior(),
                    Boolean.toString(dbParameterEntity.isCanShow()),
                    Boolean.toString(dbParameterEntity.isCanAdd()),
                    Boolean.toString(dbParameterEntity.isCanDisabled()),
                    Boolean.toString(dbParameterEntity.isCanEdit()),
                    Boolean.toString(dbParameterEntity.isCanDeleted()),
                    dbParameterEntity.getAdditional1(),
                    dbParameterEntity.getAdditional2(),
                    dbParameterEntity.getAdditional3(),
                    Boolean.toString(dbParameterEntity.isDeleted())

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
        DbParameterEntity dbParameterEntity = parameterDataMapper.transformToDb(parameter);

        try {
            if (dbParameterEntity.getName().equalsIgnoreCase("delete*ALL")) {
                parameterDAO.deleteAll();
            } else {
                parameterDAO.deleteById(dbParameterEntity.getId().toString());
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
        DbParameterEntity dbParameterEntity;

        try {
            List<DbParameterEntity> dbParameterEntities = parameterDAO.listAllQ();

            for (int i = 0; i < dbParameterEntities.size(); i++) {
                dbParameterEntity = dbParameterEntities.get(i);
                parameter = parameterDataMapper.transformFromDb(dbParameterEntity);
                parameters.add(parameter);
            }
            repositoryCallback.onSuccess(parameters);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

}
