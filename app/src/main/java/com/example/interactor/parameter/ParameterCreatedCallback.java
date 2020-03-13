package com.example.interactor.parameter;

import com.example.domain.model.Parameter;

public interface ParameterCreatedCallback {
    void onParameterCreatedSuccess(Parameter parameter);
    void onParameterCreatedError(String message);
    
}
