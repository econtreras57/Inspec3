package com.example.presentation.presenter;

import com.example.data.datasource.datastore.ParameterDataStoreFactory;
import com.example.data.repository.ParameterDataRepository;
import com.example.domain.model.Parameter;
import com.example.domain.repository.ParameterRepository;
import com.example.interactor.parameter.ParameterCreatedCallback;
import com.example.interactor.parameter.ParameterDeletedCallback;
import com.example.interactor.parameter.ParameterInteractor;
import com.example.interactor.parameter.ParameterListCallback;
import com.example.interactor.parameter.ParameterListCreatedCallback;
import com.example.interactor.parameter.ParameterUpdatedCallback;
import com.example.presentation.view.ParameterView;

import java.util.ArrayList;
import java.util.List;


public class ParameterPresenter implements
        Presenter<ParameterView>,
        ParameterCreatedCallback,
        ParameterListCreatedCallback,
        ParameterUpdatedCallback,
        ParameterDeletedCallback,
        ParameterListCallback {

    private ParameterView parameterView;
    private ParameterInteractor parameterInteractor;

    public void createParameter(Parameter parameter, int parameterDataLocation) {
        parameterInteractor.createParameter(
                parameter,
                parameterDataLocation,
                this);
    }

    public void createParameterList(List<Parameter> parameterList, int parameterDataLocation) {
        parameterInteractor.createParameterList(
                parameterList,
                parameterDataLocation,
                this);
    }

    public void updateParameter(Parameter parameter, int parameterDataLocation) {
        parameterInteractor.updateParameter(
                parameter,
                parameterDataLocation,
                this);
    }

    public void deleteParameter(Parameter parameter, int parameterDataLocation) {

        parameterInteractor.deleteParameter(
                parameter,
                parameterDataLocation,
                this);
    }

    public void loadParameters(int parameterDataLocation) {
        parameterInteractor.loadParameters(
                parameterDataLocation,
                this);
    }

    @Override
    public void addView(ParameterView view) {
        this.parameterView = view;
        ParameterRepository requestRepository =
                new ParameterDataRepository(
                        new ParameterDataStoreFactory(this.parameterView.getContext())
                );
        parameterInteractor = new ParameterInteractor(requestRepository);
    }

    @Override
    public void removeView(ParameterView view) {

    }

    @Override
    public void onParameterCreatedSuccess(Parameter parameter) {
        parameterView.parameterCreated(parameter);
    }

    @Override
    public void onParameterCreatedError(String message) {

    }

    @Override
    public void onParameterUpdatedSuccess(Parameter parameter) {
        parameterView.parameterUpdated(parameter);
    }

    @Override
    public void onParameterUpdatedError(String message) {

    }

    @Override
    public void onParameterDeletedSuccess(Parameter parameter) {
        parameterView.parameterDeleted(parameter);
    }

    @Override
    public void onParameterDeletedError(String message) {

    }

    @Override
    public void onParameterListSuccess(ArrayList<Parameter> parameterList) {
        parameterView.parametersListLoaded((ArrayList<Parameter>) parameterList);
    }

    @Override
    public void onParameterListError(String message) {

    }

    @Override
    public void onParameterListCreatedSuccess(List<Parameter> parameterList) {
        parameterView.parameterCreatedList(parameterList);

    }

    @Override
    public void onParameterListCreatedError(String message) {

    }
}
