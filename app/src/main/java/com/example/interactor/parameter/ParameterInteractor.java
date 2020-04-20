package com.example.interactor.parameter;

import com.example.domain.model.Parameter;
import com.example.domain.repository.ParameterRepository;
import com.example.interactor.parameter.ParameterCreatedCallback;
import com.example.interactor.parameter.ParameterDeletedCallback;
import com.example.interactor.parameter.ParameterListCallback;
import com.example.interactor.parameter.ParameterListCreatedCallback;
import com.example.interactor.parameter.ParameterUpdatedCallback;

import java.util.List;

public class ParameterInteractor {

    private final ParameterRepository parameterRepository;

    public ParameterInteractor(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    public void createParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterCreatedCallback parameterCreatedCallback
    ) {
        parameterRepository.createParameter(
                parameter,
                parameterDataLocation,
                parameterCreatedCallback);
    }

    public void createParameterList(
            List<Parameter> parameterList,
            int parameterDataLocation,
            ParameterListCreatedCallback parameterListCreatedCallback
    ) {
        parameterRepository.createParameterList(
                parameterList,
                parameterDataLocation,
                parameterListCreatedCallback);
    }

    public void updateParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterUpdatedCallback parameterUpdatedCallback
    ) {
        parameterRepository.updateParameter(
                parameter,
                parameterDataLocation,
                parameterUpdatedCallback);
    }

    public void deleteParameter(
            Parameter parameter,
            int parameterDataLocation,
            ParameterDeletedCallback parameterDeletedCallback) {

        parameterRepository.deleteParameter(
                parameter,
                parameterDataLocation,
                parameterDeletedCallback);
    }

    public void loadParameters(
            ParameterListCallback parameterListCallback) {
        parameterRepository.loadParameters(parameterListCallback);
    }

}
