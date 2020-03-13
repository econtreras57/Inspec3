package com.example.interactor.parameter;

import com.example.domain.model.Parameter;

import java.util.ArrayList;

public interface ParameterListCallback {
    void onParameterListSuccess(ArrayList<Parameter> parameterList);
    void onParameterListError(String message);
}
