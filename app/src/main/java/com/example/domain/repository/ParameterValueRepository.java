package com.example.domain.repository;

import com.example.domain.model.ParameterValue;
import com.example.interactor.parametervalue.ParameterValueCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueDeletedCallback;
import com.example.interactor.parametervalue.ParameterValueListCallback;
import com.example.interactor.parametervalue.ParameterValueListCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueUpdatedCallback;

import java.util.List;

public interface ParameterValueRepository {
    void createParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            ParameterValueCreatedCallback parameterValueCreatedCallback);

    void createParameterValueList(
            List<ParameterValue> parameterValueList,
            int parameterValueDataLocation,
            ParameterValueListCreatedCallback parameterValueListCreateCallback);   // 2020-02-10

    void updateParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            ParameterValueUpdatedCallback parameterValueUpdatedCallback);

    void deleteParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            ParameterValueDeletedCallback parameterValueDeletedCallback);

    void loadParameterValues(
            int parameterValueDataLocation,
            final ParameterValueListCallback requestListCallback);
    
}
