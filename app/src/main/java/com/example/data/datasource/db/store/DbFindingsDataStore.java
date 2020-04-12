package com.example.data.datasource.db.store;

import android.content.Context;

import com.example.data.datasource.datastore.FindingsDataStore;
import com.example.data.datasource.db.DbInspec3Instance;
import com.example.data.datasource.db.dao.FindingsDAO;
import com.example.data.datasource.db.model.DbFindings;
import com.example.data.mapper.FindingsDataMapper;
import com.example.domain.model.Findings;
import com.example.domain.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

public class DbFindingsDataStore implements FindingsDataStore {
    
    FindingsDAO findingsDAO;


    public DbFindingsDataStore(Context context) {
        findingsDAO = DbInspec3Instance.getDatabase(context).findingsDAO();
    }

    @Override
    public void createFindings(Findings findings, RepositoryCallback repositoryCallback) {

        FindingsDataMapper findingsDataMapper = new FindingsDataMapper();
        DbFindings dbFindings = findingsDataMapper.transformToDb(findings);

        dbFindings.setId(null);      // para que autogenere la clave ¿cierto?

        try {
            findings.setId(
                    findingsDAO.InsertOnlyOne(dbFindings).intValue()
            );
            repositoryCallback.onSuccess(findings);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void createFindingsList(
            List<Findings> findingsList,
            RepositoryCallback repositoryCallback) {

        FindingsDataMapper findingsDataMapper = new FindingsDataMapper();
//        DbFindings dbFindings=findingsDataMapper.transformToDb(findings);

        List<DbFindings> dbFindingsList = new ArrayList<>();
        for (int i = 0; i < findingsList.size(); i++) {
            Findings wrkFindings = findingsList.get(i);
            DbFindings wrkDbFindings = findingsDataMapper.transformToDb(wrkFindings);
            wrkDbFindings.setId(null);     // para que se creen automáticamente
            dbFindingsList.add(wrkDbFindings);
        }

//        dbFindings.setId( 0 ); // o null?

        try {
            findingsDAO.InsertMultiple(dbFindingsList);     // tipos... ver domain/model/findings
            repositoryCallback.onSuccess(findingsList);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void updateFindings(Findings findings, RepositoryCallback repositoryCallback) {

        FindingsDataMapper findingsDataMapper = new FindingsDataMapper();
        DbFindings dbFindings = findingsDataMapper.transformToDb(findings);

        dbFindings.setId(findings.getId());    // ojo, verificar si null

        try {
            findingsDAO.updateById(
                    dbFindings.getId().toString(),
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
            repositoryCallback.onSuccess(findings);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }

    }

    @Override
    public void deleteFindings(Findings findings, RepositoryCallback repositoryCallback) {

        FindingsDataMapper findingsDataMapper = new FindingsDataMapper();
        DbFindings dbFindings = findingsDataMapper.transformToDb(findings);

        try {
            if (dbFindings.getManagement().equalsIgnoreCase("delete*ALL")) {
                findingsDAO.deleteAll();
            } else {
                findingsDAO.deleteById(dbFindings.getId().toString());
            }
            repositoryCallback.onSuccess(findings);
        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }

    @Override
    public void findingssList(RepositoryCallback repositoryCallback) {

        FindingsDataMapper findingsDataMapper = new FindingsDataMapper();
//        DbFindings dbFindings = findingsDataMapper.transformToDb(findings);

        List<Findings> findingss = new ArrayList<>();
        Findings findings;
        DbFindings dbFindings;

        try {
            List<DbFindings> dbFindingss = findingsDAO.listAllQ();

            for (int i = 0; i < dbFindingss.size(); i++) {
//                System.out.println(crunchifyList.get(i));
                dbFindings = dbFindingss.get(i);
                findings = findingsDataMapper.transformFromDb(dbFindings);
                findingss.add(findings);
            }
            repositoryCallback.onSuccess(findingss);

        } catch (Exception e) {
            e.printStackTrace();
            repositoryCallback.onError(e);
        }
    }


}
