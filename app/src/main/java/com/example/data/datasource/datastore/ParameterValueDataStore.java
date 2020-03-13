package com.example.data.datasource.datastore;

import com.example.domain.model.ParameterValue;
import com.example.domain.repository.RepositoryCallback;

import java.util.List;

public interface ParameterValueDataStore {

    void createParameterValue(ParameterValue parameterValue,
                    RepositoryCallback repositoryCallback);

    void createParameterValueList(List<ParameterValue> parameterValueList,
                        RepositoryCallback repositoryCallback);

    void updateParameterValue(ParameterValue parameterValue,
                    RepositoryCallback repositoryCallback);

    void deleteParameterValue(ParameterValue parameterValue,
                    RepositoryCallback repositoryCallback);

    void parameterValuesList(RepositoryCallback repositoryCallback);


}
