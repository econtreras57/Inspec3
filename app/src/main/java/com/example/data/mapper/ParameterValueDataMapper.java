package com.example.data.mapper;

import com.example.data.datasource.cloud.model.CloudParameterValueEntity;
import com.example.data.datasource.db.model.DbParameterValueEntity;
import com.example.domain.model.ParameterValue;

import java.sql.Date;

public class ParameterValueDataMapper {

    public DbParameterValueEntity transformToDb(ParameterValue parameterValue)
    {
        DbParameterValueEntity dbParameterValueEntity = new DbParameterValueEntity(
                parameterValue.getId(),
                parameterValue.getIdParameter(),
                parameterValue.getIdParameterValueSuperior(),
                parameterValue.getName(),
                parameterValue.getValue(),
                parameterValue.getValueFull(),
                parameterValue.getValueAdditional1(),
                parameterValue.getValueAdditional2(),
                parameterValue.getValueAdditional3(),
                parameterValue.getOrder(),
                parameterValue.isDeleted(),
                parameterValue.getIdUserRegister(),
                parameterValue.getIdUserModify(),
                parameterValue.getDateRegister(),
                parameterValue.getDateModify(),
                parameterValue.isDeleted()

                );
        return dbParameterValueEntity;
    }

    public ParameterValue transformFromDb(DbParameterValueEntity dbParameterValueEntity)
    {
        ParameterValue parameterValue = new ParameterValue(
                dbParameterValueEntity.getId(),
                dbParameterValueEntity.getIdParameter(),
                dbParameterValueEntity.getIdParameterValueSuperior(),
                dbParameterValueEntity.getName(),
                dbParameterValueEntity.getValue(),
                dbParameterValueEntity.getValueFull(),
                dbParameterValueEntity.getValueAdditional1(),
                dbParameterValueEntity.getValueAdditional2(),
                dbParameterValueEntity.getValueAdditional3(),
                dbParameterValueEntity.getOrder(),
                dbParameterValueEntity.isEnable(),
                dbParameterValueEntity.getIdUserRegister(),
                dbParameterValueEntity.getIdUserModify(),
                dbParameterValueEntity.getDateRegister(),
                dbParameterValueEntity.getDateModify(),
                dbParameterValueEntity.isDeleted()

                );
        return parameterValue;
    }

    public CloudParameterValueEntity transformToCloud(ParameterValue parameterValue)
    {
        CloudParameterValueEntity cloudParameterValueEntity = 
                new CloudParameterValueEntity(
                parameterValue.getId(),
                parameterValue.getIdParameter(),
                parameterValue.getIdParameterValueSuperior(),
                parameterValue.getName(),
                parameterValue.getValue(),
                parameterValue.getValueFull(),
                parameterValue.getValueAdditional1(),
                parameterValue.getValueAdditional2(),
                parameterValue.getValueAdditional3(),
                Integer.toString(parameterValue.getOrder()),
                Boolean.toString(parameterValue.isEnable()),
                parameterValue.getIdUserRegister(),
                parameterValue.getIdUserModify(),
                parameterValue.getDateRegister().toString(),
                parameterValue.getDateModify().toString(),
                parameterValue.isDeleted()

        );
        return cloudParameterValueEntity;
    }

    public ParameterValue transformFromCloud(
            CloudParameterValueEntity cloudParameterValueEntity)
    {
        ParameterValue parameterValue = new ParameterValue(
                cloudParameterValueEntity.getId(),
                cloudParameterValueEntity.getIdParameter(),
                cloudParameterValueEntity.getIdParameterValueSuperior(),
                cloudParameterValueEntity.getName(),
                cloudParameterValueEntity.getValue(),
                cloudParameterValueEntity.getValueFull(),
                cloudParameterValueEntity.getValueAdditional1(),
                cloudParameterValueEntity.getValueAdditional2(),
                cloudParameterValueEntity.getValueAdditional3(),
                Integer.parseInt(cloudParameterValueEntity.getOrder()),
                Boolean.getBoolean(cloudParameterValueEntity.isEnable()),
                cloudParameterValueEntity.getIdUserRegister(),
                cloudParameterValueEntity.getIdUserModify(),
                Date.valueOf(cloudParameterValueEntity.getDateRegister()),
                Date.valueOf(cloudParameterValueEntity.getDateModify().toString()),
                cloudParameterValueEntity.isDeleted()

        );
        return parameterValue;
    }

}
