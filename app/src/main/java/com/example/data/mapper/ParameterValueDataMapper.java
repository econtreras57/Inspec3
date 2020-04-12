package com.example.data.mapper;

import com.example.data.datasource.db.model.DbParameterValueEntity;
import com.example.domain.model.ParameterValue;

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
    
}
