package com.example.presentation.view;

import com.example.domain.model.Parameter;

import java.util.List;

public interface LoginView extends BaseView {

    void showErrorMessage(String message);

    void parameterListSuccess(List<Parameter> parameters);
}
