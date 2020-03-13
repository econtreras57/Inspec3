package com.example.interactor.parametervalue;

import com.example.domain.model.ParameterValue;

import java.util.List;

public interface ParameterValueListCreatedCallback {
    void onParameterValueListCreatedSuccess(List<ParameterValue> parameterValueList);
    void onParameterValueListCreatedError(String message);

}
