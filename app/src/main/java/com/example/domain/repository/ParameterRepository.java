package com.example.domain.repository;

import com.example.domain.model.Parameter;
import com.example.interactor.parameter.ParameterCreatedCallback;
import com.example.interactor.parameter.ParameterDeletedCallback;
import com.example.interactor.parameter.ParameterListCallback;
import com.example.interactor.parameter.ParameterListCreatedCallback;
import com.example.interactor.parameter.ParameterUpdatedCallback;

import java.util.List;

public interface ParameterRepository {

    // Create one
    void createParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterCreatedCallback parameterCreatedCallback);

    // Create batch
    void createParameterList(
            List<Parameter> parameterList,
            int parameterDataLocation,
            ParameterListCreatedCallback parameterListCreateCallback);   // 2020-02-10

    // Read one 2020-04-11
    void getParameter(
            Parameter parameter,
            int parameterDataLocation,
            final ParameterListCallback requestListCallback);

    // Read all
    void loadParameters(final ParameterListCallback requestListCallback);

    // Update one
    void updateParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterUpdatedCallback parameterUpdatedCallback);

    // Delete one
    void deleteParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterDeletedCallback parameterDeletedCallback);

}
