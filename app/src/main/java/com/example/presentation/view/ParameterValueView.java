package com.example.presentation.view;

import com.example.domain.model.ParameterValue;

import java.util.ArrayList;
import java.util.List;

public interface ParameterValueView extends BaseView {
    void parameterValueCreated(ParameterValue parameterValue);

    void parameterValueCreatedList(List<ParameterValue> parameterValueList);

    void parameterValueUpdated(ParameterValue parameterValue);

    void parameterValueDeleted(ParameterValue parameterValue);

    void parameterValuesListLoaded(ArrayList<ParameterValue> parameterValues);

    void showErrorMessage(String message);
}
