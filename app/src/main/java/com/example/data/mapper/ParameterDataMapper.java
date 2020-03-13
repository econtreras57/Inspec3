package com.example.data.mapper;

import com.example.data.datasource.db.model.ParameterDbEntity;
import com.example.domain.model.Parameter;

public class ParameterDataMapper {

    public ParameterDbEntity transformToDb(Parameter parameter)
    {
        ParameterDbEntity parameterDbEntity= new ParameterDbEntity(
//                parameter.getId(),
                parameter.getId(),
                parameter.getName(),
                parameter.getIdParameterSuperior(),
                parameter.isCanShow(),
                parameter.isCanAdd(),
                parameter.isCanDisabled(),
                parameter.isCanEdit(),
                parameter.isCanDeleted(),
                parameter.getAdditional1(),
                parameter.getAdditional2(),
                parameter.getAdditional3(),
                parameter.isDeleted()

                );
        return parameterDbEntity;
    }

    public Parameter transformFromDb(ParameterDbEntity parameterDbEntity)
    {
        Parameter parameter = new Parameter(
                parameterDbEntity.getId(),
                parameterDbEntity.getName(),
                parameterDbEntity.getIdParameterSuperior(),
                parameterDbEntity.isCanShow(),
                parameterDbEntity.isCanAdd(),
                parameterDbEntity.isCanDisabled(),
                parameterDbEntity.isCanEdit(),
                parameterDbEntity.isCanDeleted(),
                parameterDbEntity.getAdditional1(),
                parameterDbEntity.getAdditional2(),
                parameterDbEntity.getAdditional3(),
                parameterDbEntity.isDeleted()

                );
        return parameter;
    }
    
}
