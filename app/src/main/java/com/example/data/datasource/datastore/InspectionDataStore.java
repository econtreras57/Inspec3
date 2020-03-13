package com.example.data.datasource.datastore;

import com.example.domain.model.Inspection;
import com.example.domain.repository.RepositoryCallback;

import java.util.List;

public interface InspectionDataStore {

    void createInspection(Inspection inspection,
                    RepositoryCallback repositoryCallback);

    void createInspectionList(List<Inspection> inspectionList,
                        RepositoryCallback repositoryCallback);

    void updateInspection(Inspection inspection,
                    RepositoryCallback repositoryCallback);

    void deleteInspection(Inspection inspection,
                    RepositoryCallback repositoryCallback);

    void inspectionsList( RepositoryCallback repositoryCallback);
    
}
