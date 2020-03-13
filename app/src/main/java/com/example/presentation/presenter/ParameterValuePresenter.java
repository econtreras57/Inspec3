package com.example.presentation.presenter;

import com.example.data.datasource.datastore.ParameterValueDataStoreFactory;
import com.example.data.repository.ParameterValueDataRepository;
import com.example.domain.model.ParameterValue;
import com.example.domain.repository.ParameterValueRepository;
import com.example.interactor.parametervalue.ParameterValueCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueDeletedCallback;
import com.example.interactor.parametervalue.ParameterValueInteractor;
import com.example.interactor.parametervalue.ParameterValueListCallback;
import com.example.interactor.parametervalue.ParameterValueListCreatedCallback;
import com.example.interactor.parametervalue.ParameterValueUpdatedCallback;
import com.example.presentation.view.ParameterValueView;

import java.util.ArrayList;
import java.util.List;


public class ParameterValuePresenter implements
        Presenter<ParameterValueView>,
        ParameterValueCreatedCallback,
        ParameterValueListCreatedCallback,
        ParameterValueUpdatedCallback,
        ParameterValueDeletedCallback,
        ParameterValueListCallback {

    private ParameterValueView parameterValueView;
    private ParameterValueInteractor parameterValueInteractor;

    public void createParameterValue(ParameterValue parameterValue, int parameterValueDataLocation) {
        parameterValueInteractor.createParameterValue(
                parameterValue,
                parameterValueDataLocation,
                this);
    }

    public void createParameterValueList(List<ParameterValue> parameterValueList, int parameterValueDataLocation) {
        parameterValueInteractor.createParameterValueList(
                parameterValueList,
                parameterValueDataLocation,
                this);
    }

    public void updateParameterValue(ParameterValue parameterValue, int parameterValueDataLocation) {
        parameterValueInteractor.updateParameterValue(
                parameterValue,
                parameterValueDataLocation,
                this);
    }

    public void deleteParameterValue(ParameterValue parameterValue, int parameterValueDataLocation) {

        parameterValueInteractor.deleteParameterValue(
                parameterValue,
                parameterValueDataLocation,
                this);
    }

    public void loadParameterValues(int parameterValueDataLocation) {
        parameterValueInteractor.loadParameterValues(
                parameterValueDataLocation,
                this);
    }

    @Override
    public void addView(ParameterValueView view) {
        this.parameterValueView = view;
        ParameterValueRepository requestRepository =
                new ParameterValueDataRepository(
                        new ParameterValueDataStoreFactory(this.parameterValueView.getContext())
                );
        parameterValueInteractor = new ParameterValueInteractor(requestRepository);
    }

    @Override
    public void removeView(ParameterValueView view) {

    }

    @Override
    public void onParameterValueCreatedSuccess(ParameterValue parameterValue) {
        parameterValueView.parameterValueCreated(parameterValue);
    }

    @Override
    public void onParameterValueCreatedError(String message) {

    }

    @Override
    public void onParameterValueUpdatedSuccess(ParameterValue parameterValue) {
        parameterValueView.parameterValueUpdated(parameterValue);
    }

    @Override
    public void onParameterValueUpdatedError(String message) {

    }

    @Override
    public void onParameterValueDeletedSuccess(ParameterValue parameterValue) {
        parameterValueView.parameterValueDeleted(parameterValue);
    }

    @Override
    public void onParameterValueDeletedError(String message) {

    }

    @Override
    public void onParameterValueListSuccess(ArrayList<ParameterValue> parameterValueList) {
        parameterValueView.parameterValuesListLoaded((ArrayList<ParameterValue>) parameterValueList);
    }

    @Override
    public void onParameterValueListError(String message) {

    }

    @Override
    public void onParameterValueListCreatedSuccess(List<ParameterValue> parameterValueList) {
        parameterValueView.parameterValueCreatedList(parameterValueList);

    }

    @Override
    public void onParameterValueListCreatedError(String message) {

    }
}
