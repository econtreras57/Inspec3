package com.example.data.datasource.cloud.store;

import android.content.Context;

import com.example.data.datasource.datastore.ParameterValueDataStore;
import com.example.data.datasource.db.DbInspec3Instance;
import com.example.data.datasource.db.dao.ParameterValueDAO;
import com.example.data.datasource.db.model.DbParameterValueEntity;
import com.example.data.mapper.ParameterValueDataMapper;
import com.example.domain.model.ParameterValue;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

public class CloudParameterValueEntityDataStore implements ParameterValueDataStore {

    ParameterValueDAO parameterValueDAO;

    public CloudParameterValueEntityDataStore(Context context) {
        parameterValueDAO = DbInspec3Instance.getDatabase(context).parameterValueDAO();
    }

    @Override
    public void createParameterValue(ParameterValue parameterValue, RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
        DbParameterValueEntity dbParameterValueEntity = parameterValueDataMapper.transformToDb(parameterValue);

        dbParameterValueEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            parameterValue.setId(
                    parameterValueDAO.InsertOnlyOne(dbParameterValueEntity).toString()
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

        List<DbParameterValueEntity> dbParameterValueEntityList = new ArrayList<>();
        for (int i = 0; i < parameterValueList.size(); i++) {
            ParameterValue wrkParameterValue = parameterValueList.get(i);
            DbParameterValueEntity wrkDbParameterValueEntity = parameterValueDataMapper.transformToDb(wrkParameterValue);
            wrkDbParameterValueEntity.setId(null);     // para que se creen automáticamente
            dbParameterValueEntityList.add(wrkDbParameterValueEntity);
        }

//        parameterValueDbEntity.setId( 0 ); // o null?

        try {
            parameterValueDAO.InsertMultiple(dbParameterValueEntityList);     // tipos... ver domain/model/parameterValue
            repositoryCallback.onSuccess(parameterValueList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateParameterValue(ParameterValue parameterValue, RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
        DbParameterValueEntity dbParameterValueEntity = parameterValueDataMapper.transformToDb(parameterValue);

        dbParameterValueEntity.setId(parameterValue.getId()); // ojo, verificar si null

        try {
            parameterValueDAO.updateById(
                    dbParameterValueEntity.getId(),
                    dbParameterValueEntity.getIdParameter(),
                    dbParameterValueEntity.getIdParameterValueSuperior(),
                    dbParameterValueEntity.getName(),
                    dbParameterValueEntity.getValue(),
                    dbParameterValueEntity.getValueFull(),
                    dbParameterValueEntity.getValueAdditional1(),
                    dbParameterValueEntity.getValueAdditional2(),
                    dbParameterValueEntity.getValueAdditional3(),
                    Integer.toString(dbParameterValueEntity.getOrder()),
                    Boolean.toString(dbParameterValueEntity.isEnable()),
                    dbParameterValueEntity.getIdUserRegister(),
                    dbParameterValueEntity.getIdUserModify(),
                    dbParameterValueEntity.getDateRegister().toString(),
                    dbParameterValueEntity.getDateModify().toString(),
                    Boolean.toString(dbParameterValueEntity.isDeleted())

                    );
            repositoryCallback.onSuccess(parameterValue);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void deleteParameterValue(ParameterValue parameterValue, RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
        DbParameterValueEntity dbParameterValueEntity = parameterValueDataMapper.transformToDb(parameterValue);

        try {
            if (dbParameterValueEntity.getName().equalsIgnoreCase("delete*ALL")) {
                parameterValueDAO.deleteAll();
            } else {
                parameterValueDAO.deleteById(dbParameterValueEntity.getId().toString());
            }
            repositoryCallback.onSuccess(parameterValue);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void parameterValuesList(RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
//        ParameterValueDbEntity parameterValueDbEntity = parameterValueDataMapper.transformToDb(parameterValue);

        List<ParameterValue> parameterValues = new ArrayList<>();
        ParameterValue parameterValue;
        DbParameterValueEntity dbParameterValueEntity;

        try {
            List<DbParameterValueEntity> dbParameterValueEntities = parameterValueDAO.listAllQ();

            for (int i = 0; i < dbParameterValueEntities.size(); i++) {
//                System.out.println(crunchifyList.get(i));
                dbParameterValueEntity = dbParameterValueEntities.get(i);
                parameterValue = parameterValueDataMapper.transformFromDb(dbParameterValueEntity);
                parameterValues.add(parameterValue);
            }
            repositoryCallback.onSuccess(parameterValues);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }


}
