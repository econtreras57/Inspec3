package com.example.data.datasource.datastore;

import com.example.domain.model.Findings;
import com.example.domain.repository.RepositoryCallback;

import java.util.List;

public interface FindingsDataStore {

    void createFindings(Findings findings,
                          RepositoryCallback repositoryCallback);

    void createFindingsList(List<Findings> findingsList,
                              RepositoryCallback repositoryCallback);

    void updateFindings(Findings findings,
                          RepositoryCallback repositoryCallback);

    void deleteFindings(Findings findings,
                          RepositoryCallback repositoryCallback);

    void findingssList( RepositoryCallback repositoryCallback);


}
