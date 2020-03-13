package com.example.interactor.parameter;

import com.example.domain.model.Parameter;

public interface ParameterUpdatedCallback {
    void onParameterUpdatedSuccess(Parameter parameter);
    void onParameterUpdatedError(String message);

}
