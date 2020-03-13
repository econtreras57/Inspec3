package com.example.data.mapper;

import com.example.data.datasource.db.model.ParameterDbEntity;
import com.example.data.datasource.db.model.ParameterValueDbEntity;
import com.example.domain.model.Parameter;
import com.example.domain.model.ParameterValue;

public class ParameterValueDataMapper {

    public ParameterValueDbEntity transformToDb(ParameterValue parameterValue)
    {
        ParameterValueDbEntity parameterValueDbEntity= new ParameterValueDbEntity(
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
        return parameterValueDbEntity;
    }

    public ParameterValue transformFromDb(ParameterValueDbEntity parameterValueDbEntity)
    {
        ParameterValue parameterValue = new ParameterValue(
                parameterValueDbEntity.getId(),
                parameterValueDbEntity.getIdParameter(),
                parameterValueDbEntity.getIdParameterValueSuperior(),
                parameterValueDbEntity.getName(),
                parameterValueDbEntity.getValue(),
                parameterValueDbEntity.getValueFull(),
                parameterValueDbEntity.getValueAdditional1(),
                parameterValueDbEntity.getValueAdditional2(),
                parameterValueDbEntity.getValueAdditional3(),
                parameterValueDbEntity.getOrder(),
                parameterValueDbEntity.isEnable(),
                parameterValueDbEntity.getIdUserRegister(),
                parameterValueDbEntity.getIdUserModify(),
                parameterValueDbEntity.getDateRegister(),
                parameterValueDbEntity.getDateModify(),
                parameterValueDbEntity.isDeleted()

                );
        return parameterValue;
    }
    
}
