package com.example.interactor.parametervalue;

import com.example.domain.model.ParameterValue;

public interface ParameterValueUpdatedCallback {
    void onParameterValueUpdatedSuccess(ParameterValue parameterValue);
    void onParameterValueUpdatedError(String message);

}
