package com.example.interactor.parametervalue;

import com.example.domain.model.ParameterValue;

public interface ParameterValueDeletedCallback {
    void onParameterValueDeletedSuccess(ParameterValue parameterValue);
    void onParameterValueDeletedError(String message);

}
