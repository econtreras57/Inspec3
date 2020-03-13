package com.example.data.mapper;

import com.example.data.datasource.db.model.DbInspection;
import com.example.domain.model.Inspection;

public class InspectionDataMapper {

    public DbInspection transformToDb(Inspection inspection)
    {
        DbInspection dbInspection= new DbInspection(
//                inspection.getId(),
                inspection.getId(),
                inspection.getInspector(),
                inspection.getDate(),
                inspection.getStatusDate(),
                inspection.getStatus(),
                inspection.getSubStatusDate(),
                inspection.getSubStatus(),
                inspection.getPlanned(),
                inspection.getProject(),
                inspection.getContractor(),
                inspection.getLocType(),
                inspection.getSite(),
                inspection.getResponsible()

                );
        return dbInspection;
    }

    public Inspection transformFromDb(DbInspection dbInspection)
    {
        Inspection inspection = new Inspection(
                dbInspection.getId(),
                dbInspection.getInspector(),
                dbInspection.getDate(),
                dbInspection.getStatusDate(),
                dbInspection.getStatus(),
                dbInspection.getSubStatusDate(),
                dbInspection.getSubStatus(),
                dbInspection.getPlanned(),
                dbInspection.getProject(),
                dbInspection.getContractor(),
                dbInspection.getLocType(),
                dbInspection.getSite(),
                dbInspection.getResponsible()

                );
        return inspection;
    }


}
