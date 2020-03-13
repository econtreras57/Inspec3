package com.example.interactor.parameter;

import com.example.domain.model.Parameter;

public interface ParameterDeletedCallback {
    void onParameterDeletedSuccess(Parameter parameter);
    void onParameterDeletedError(String message);

}
