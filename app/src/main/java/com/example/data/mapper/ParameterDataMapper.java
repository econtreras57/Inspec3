package com.example.data.mapper;

import com.example.data.datasource.cloud.model.CloudParameterEntity;
import com.example.data.datasource.db.model.DbParameterEntity;
import com.example.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ParameterDataMapper {

    public DbParameterEntity transformToDb(Parameter parameter) {
        DbParameterEntity dbParameterEntity = new DbParameterEntity(
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
        return dbParameterEntity;
    }

    public CloudParameterEntity transformToCloud(Parameter parameter) {
        CloudParameterEntity cloudParameterEntity = new CloudParameterEntity(
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
        return cloudParameterEntity;
    }

    public Parameter transformFromDb(DbParameterEntity dbParameterEntity) {
        Parameter parameter = new Parameter(
                dbParameterEntity.getId(),
                dbParameterEntity.getName(),
                dbParameterEntity.getIdParameterSuperior(),
                dbParameterEntity.isCanShow(),
                dbParameterEntity.isCanAdd(),
                dbParameterEntity.isCanDisabled(),
                dbParameterEntity.isCanEdit(),
                dbParameterEntity.isCanDeleted(),
                dbParameterEntity.getAdditional1(),
                dbParameterEntity.getAdditional2(),
                dbParameterEntity.getAdditional3(),
                dbParameterEntity.isDeleted()

        );
        return parameter;
    }

    public Parameter transformFromCloud(CloudParameterEntity cloudParameterEntity) {
        Parameter parameter = new Parameter(
                cloudParameterEntity.getId(),
                cloudParameterEntity.getName(),
                cloudParameterEntity.getIdParameterSuperior(),
                cloudParameterEntity.isCanShow(),
                cloudParameterEntity.isCanAdd(),
                cloudParameterEntity.isCanDisabled(),
                cloudParameterEntity.isCanEdit(),
                cloudParameterEntity.isCanDeleted(),
                cloudParameterEntity.getAdditional1(),
                cloudParameterEntity.getAdditional2(),
                cloudParameterEntity.getAdditional3(),
                cloudParameterEntity.isDeleted()
        );
        return parameter;
    }

    public List<Parameter> transformListCloud(List<CloudParameterEntity> cloudParameterEntities) {
        List<Parameter> list = new ArrayList<>();
        if (cloudParameterEntities == null) return list;
        for (CloudParameterEntity wsEntity : cloudParameterEntities) {
            list.add(transformFromCloud(wsEntity));
        }
        return list;
    }

}
