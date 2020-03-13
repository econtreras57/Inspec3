package com.example.interactor.parametervalue;

import com.example.domain.model.ParameterValue;

public interface ParameterValueCreatedCallback {
    void onParameterValueCreatedSuccess(ParameterValue parameterValue);
    void onParameterValueCreatedError(String message);
    
}
