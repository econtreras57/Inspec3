package com.example.data.datasource.datastore;

import com.example.domain.model.Parameter;
import com.example.domain.repository.RepositoryCallback;

import java.util.List;

public interface ParameterDataStore {

    void createParameter(Parameter parameter,
                    RepositoryCallback repositoryCallback);

    void createParameterList(List<Parameter> parameterList,
                        RepositoryCallback repositoryCallback);

    void updateParameter(Parameter parameter,
                    RepositoryCallback repositoryCallback);

    void deleteParameter(Parameter parameter,
                    RepositoryCallback repositoryCallback);

    void parametersList(RepositoryCallback repositoryCallback);


}
