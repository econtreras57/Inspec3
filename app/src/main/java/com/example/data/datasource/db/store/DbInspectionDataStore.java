package com.example.data.datasource.db.store;

import android.content.Context;

import com.example.data.datasource.datastore.InspectionDataStore;
import com.example.data.datasource.db.DbInspec3Instance;
import com.example.data.datasource.db.dao.InspectionDAO;
import com.example.data.datasource.db.model.DbInspection;
import com.example.data.mapper.InspectionDataMapper;
import com.example.domain.model.Inspection;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

public class DbInspectionDataStore implements InspectionDataStore {

    InspectionDAO inspectionDAO;


    public DbInspectionDataStore(Context context) {
        inspectionDAO = DbInspec3Instance.getDatabase(context).inspectionDAO();
    }

    @Override
    public void createInspection(Inspection inspection, RepositoryCallback repositoryCallback) {

        InspectionDataMapper inspectionDataMapper = new InspectionDataMapper();
        DbInspection dbInspection = inspectionDataMapper.transformToDb(inspection);

        dbInspection.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            inspection.setId(
                    inspectionDAO.InsertOnlyOne(dbInspection).intValue()
            );
            repositoryCallback.onSuccess(inspection);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void createInspectionList(
            List<Inspection> inspectionList,
            RepositoryCallback repositoryCallback) {

        InspectionDataMapper inspectionDataMapper = new InspectionDataMapper();
//        DbInspection dbInspection=inspectionDataMapper.transformToDb(inspection);

        List<DbInspection> dbInspectionList = new ArrayList<>();
        for (int i = 0; i < inspectionList.size(); i++) {
            Inspection wrkInspection = inspectionList.get(i);
            DbInspection wrkDbInspection = inspectionDataMapper.transformToDb(wrkInspection);
            wrkDbInspection.setId(null);     // para que se creen automáticamente
            dbInspectionList.add(wrkDbInspection);
        }

//        dbInspection.setId( 0 ); // o null?

        try {
            inspectionDAO.InsertMultiple(dbInspectionList);     // tipos... ver domain/model/inspection
            repositoryCallback.onSuccess(inspectionList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateInspection(Inspection inspection, RepositoryCallback repositoryCallback) {

        InspectionDataMapper inspectionDataMapper = new InspectionDataMapper();
        DbInspection dbInspection = inspectionDataMapper.transformToDb(inspection);

        dbInspection.setId(inspection.getId());    // ojo, verificar si null

        try {
            inspectionDAO.updateById(
                    dbInspection.getId().toString(),
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
            repositoryCallback.onSuccess(inspection);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void deleteInspection(Inspection inspection, RepositoryCallback repositoryCallback) {

        InspectionDataMapper inspectionDataMapper = new InspectionDataMapper();
        DbInspection dbInspection = inspectionDataMapper.transformToDb(inspection);

        try {
            if (dbInspection.getInspector().equalsIgnoreCase("delete*ALL")) {
                inspectionDAO.deleteAll();
            } else {
                inspectionDAO.deleteById(dbInspection.getId().toString());
            }
            repositoryCallback.onSuccess(inspection);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void inspectionsList(RepositoryCallback repositoryCallback) {

        InspectionDataMapper inspectionDataMapper = new InspectionDataMapper();
//        DbInspection dbInspection = inspectionDataMapper.transformToDb(inspection);

        List<Inspection> inspections = new ArrayList<>();
        Inspection inspection;
        DbInspection dbInspection;

        try {
            List<DbInspection> dbInspections = inspectionDAO.listAllQ();

            for (int i = 0; i < dbInspections.size(); i++) {
//                System.out.println(crunchifyList.get(i));
                dbInspection = dbInspections.get(i);
                inspection = inspectionDataMapper.transformFromDb(dbInspection);
                inspections.add(inspection);
            }
            repositoryCallback.onSuccess(inspections);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }


}
