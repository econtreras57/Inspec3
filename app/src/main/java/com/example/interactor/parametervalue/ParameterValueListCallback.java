package com.example.interactor.parametervalue;

import com.example.domain.model.ParameterValue;

import java.util.ArrayList;

public interface ParameterValueListCallback {
    void onParameterValueListSuccess(ArrayList<ParameterValue> parameterValueList);
    void onParameterValueListError(String message);
}
