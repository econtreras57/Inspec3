package com.example.interactor.parameter;

import com.example.domain.model.Parameter;

import java.util.List;

public interface ParameterListCreatedCallback {
    void onParameterListCreatedSuccess(List<Parameter> parameterList);
    void onParameterListCreatedError(String message);

}
