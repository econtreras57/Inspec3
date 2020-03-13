package com.example.domain.repository;

import com.example.domain.model.Parameter;
import com.example.interactor.parameter.ParameterCreatedCallback;
import com.example.interactor.parameter.ParameterDeletedCallback;
import com.example.interactor.parameter.ParameterListCallback;
import com.example.interactor.parameter.ParameterListCreatedCallback;
import com.example.interactor.parameter.ParameterUpdatedCallback;

import java.util.List;

public interface ParameterRepository {
    void createParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterCreatedCallback parameterCreatedCallback);

    void createParameterList(
            List<Parameter> parameterList,
            int parameterDataLocation,
            ParameterListCreatedCallback parameterListCreateCallback);   // 2020-02-10

    void updateParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterUpdatedCallback parameterUpdatedCallback);

    void deleteParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterDeletedCallback parameterDeletedCallback);

    void loadParameters(
            int parameterDataLocation,
            final ParameterListCallback requestListCallback);
    
}
