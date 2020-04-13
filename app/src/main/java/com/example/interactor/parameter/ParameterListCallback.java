package com.example.interactor.parameter;

import com.example.domain.model.Parameter;

import java.util.List;

public interface ParameterListCallback {
    void onParameterListSuccess(List<Parameter> parameterList);
    void onParameterListError(String message);
}
