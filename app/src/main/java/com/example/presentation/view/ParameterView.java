package com.example.presentation.view;

import com.example.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

public interface ParameterView extends BaseView {
    void parameterCreated(Parameter parameter);

    void parameterCreatedList(List<Parameter> parameterList);

    void parameterUpdated(Parameter parameter);

    void parameterDeleted(Parameter parameter);

    void parametersListLoaded(ArrayList<Parameter> parameters);

    void showErrorMessage(String message);
}
