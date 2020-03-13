package com.example.data.mapper;

import com.example.data.datasource.db.model.DbFindings;
import com.example.domain.model.Findings;

public class FindingsDataMapper {

    public DbFindings transformToDb(Findings findings)
    {
        DbFindings dbFindings= new DbFindings(
//                findings.getId(),
                findings.getId(),
                findings.getInspectionId(),
                findings.getType(),
                findings.getSubType(),
                findings.getManagement(),
                findings.getText(),
                findings.getPhoto_1(),
                findings.getPhoto_2(),
                findings.getRiskLevel(),
                findings.getDate(),
                findings.getStatusDate(),
                findings.getPlannedClosureDate(),
                findings.getStatus()

        );
        return dbFindings;
    }

    public Findings transformFromDb(DbFindings dbFindings)
    {
        Findings findings = new Findings(
                dbFindings.getId(),
                dbFindings.getInspectionId(),
                dbFindings.getType(),
                dbFindings.getSubType(),
                dbFindings.getManagement(),
                dbFindings.getText(),
                dbFindings.getPhoto_1(),
                dbFindings.getPhoto_2(),
                dbFindings.getRiskLevel(),
                dbFindings.getDate(),
                dbFindings.getStatusDate(),
                dbFindings.getPlannedClosureDate(),
                dbFindings.getStatus()

        );
        return findings;
    }


}
