package com.example.interactor.parametervalue;

import com.example.domain.model.ParameterValue;
import com.example.domain.repository.ParameterValueRepository;
import com.example.interactor.parametervalue.ParameterValueCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueDeletedCallback;
import com.example.interactor.parametervalue.ParameterValueListCallback;
import com.example.interactor.parametervalue.ParameterValueListCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueUpdatedCallback;

import java.util.List;

public class ParameterValueInteractor {

    private final ParameterValueRepository parameterValueRepository;

    public ParameterValueInteractor(ParameterValueRepository parameterValueRepository) {
        this.parameterValueRepository = parameterValueRepository;
    }

    public void createParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            ParameterValueCreatedCallback parameterValueCreatedCallback
    ) {
        parameterValueRepository.createParameterValue(
                parameterValue,
                parameterValueDataLocation,
                parameterValueCreatedCallback);
    }

    public void createParameterValueList(
            List<ParameterValue> parameterValueList,
            int parameterValueDataLocation,
            ParameterValueListCreatedCallback parameterValueListCreatedCallback
    ) {
        parameterValueRepository.createParameterValueList(
                parameterValueList,
                parameterValueDataLocation,
                parameterValueListCreatedCallback);
    }

    public void updateParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            ParameterValueUpdatedCallback parameterValueUpdatedCallback
    ) {
        parameterValueRepository.updateParameterValue(
                parameterValue,
                parameterValueDataLocation,
                parameterValueUpdatedCallback);
    }

    public void deleteParameterValue(
            ParameterValue parameterValue,
            int parameterValueDataLocation,
            ParameterValueDeletedCallback parameterValueDeletedCallback) {

        parameterValueRepository.deleteParameterValue(
                parameterValue,
                parameterValueDataLocation,
                parameterValueDeletedCallback);
    }

    public void loadParameterValues(
            String parameterId,
            int parameterValueDataLocation,
            ParameterValueListCallback parameterValueListCallback) {

        parameterValueRepository.loadParameterValues(
                parameterId,
                parameterValueDataLocation,
                parameterValueListCallback);
    }

}
