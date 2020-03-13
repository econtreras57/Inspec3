package com.example.data.datasource.db.store;

import android.content.Context;

import com.example.data.datasource.datastore.ParameterValueDataStore;
import com.example.data.datasource.db.Inspec3Db;
import com.example.data.datasource.db.dao.ParameterValueDAO;
import com.example.data.datasource.db.model.ParameterValueDbEntity;
import com.example.data.mapper.ParameterValueDataMapper;
import com.example.domain.model.ParameterValue;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

public class ParameterValueDbEntityDataStore implements ParameterValueDataStore {

    ParameterValueDAO parameterValueDAO;

    public ParameterValueDbEntityDataStore(Context context) {
        parameterValueDAO = Inspec3Db.getDatabase(context).parameterValueDAO();
    }

    @Override
    public void createParameterValue(ParameterValue parameterValue, RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
        ParameterValueDbEntity parameterValueDbEntity = parameterValueDataMapper.transformToDb(parameterValue);

        parameterValueDbEntity.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            parameterValue.setId(
                    parameterValueDAO.InsertOnlyOne(parameterValueDbEntity).toString()
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

        List<ParameterValueDbEntity> parameterValueDbEntityList = new ArrayList<>();
        for (int i = 0; i < parameterValueList.size(); i++) {
            ParameterValue wrkParameterValue = parameterValueList.get(i);
            ParameterValueDbEntity wrkParameterValueDbEntity = parameterValueDataMapper.transformToDb(wrkParameterValue);
            wrkParameterValueDbEntity.setId(null);     // para que se creen automáticamente
            parameterValueDbEntityList.add(wrkParameterValueDbEntity);
        }

//        parameterValueDbEntity.setId( 0 ); // o null?

        try {
            parameterValueDAO.InsertMultiple(parameterValueDbEntityList);     // tipos... ver domain/model/parameterValue
            repositoryCallback.onSuccess(parameterValueList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateParameterValue(ParameterValue parameterValue, RepositoryCallback repositoryCallback) {

        ParameterValueDataMapper parameterValueDataMapper = new ParameterValueDataMapper();
        ParameterValueDbEntity parameterValueDbEntity = parameterValueDataMapper.transformToDb(parameterValue);

        parameterValueDbEntity.setId(parameterValue.getId()); // ojo, verificar si null

        try {
            parameterValueDAO.updateById(
                    parameterValueDbEntity.getId(),
                    parameterValueDbEntity.getIdParameter(),
                    parameterValueDbEntity.getIdParameterValueSuperior(),
                    parameterValueDbEntity.getName(),
                    parameterValueDbEntity.getValue(),
                    parameterValueDbEntity.getValueFull(),
                    parameterValueDbEntity.getValueAdditional1(),
                    parameterValueDbEntity.getValueAdditional2(),
                    parameterValueDbEntity.getValueAdditional3(),
                    Integer.toString(parameterValueDbEntity.getOrder()),
                    Boolean.toString(parameterValueDbEntity.isEnable()),
                    parameterValueDbEntity.getIdUserRegister(),
                    parameterValueDbEntity.getIdUserModify(),
                    parameterValueDbEntity.getDateRegister().toString(),
                    parameterValueDbEntity.getDateModify().toString(),
                    Boolean.toString(parameterValueDbEntity.isDeleted())

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
        ParameterValueDbEntity parameterValueDbEntity = parameterValueDataMapper.transformToDb(parameterValue);

        try {
            if (parameterValueDbEntity.getName().equalsIgnoreCase("delete*ALL")) {
                parameterValueDAO.deleteAll();
            } else {
                parameterValueDAO.deleteById(parameterValueDbEntity.getId().toString());
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
        ParameterValueDbEntity parameterValueDbEntity;

        try {
            List<ParameterValueDbEntity> parameterValueDbEntitys = parameterValueDAO.listAllQ();

            for (int i = 0; i < parameterValueDbEntitys.size(); i++) {
//                System.out.println(crunchifyList.get(i));
                parameterValueDbEntity = parameterValueDbEntitys.get(i);
                parameterValue = parameterValueDataMapper.transformFromDb(parameterValueDbEntity);
                parameterValues.add(parameterValue);
            }
            repositoryCallback.onSuccess(parameterValues);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }


}
