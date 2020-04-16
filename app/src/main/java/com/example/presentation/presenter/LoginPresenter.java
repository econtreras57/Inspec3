package com.example.presentation.presenter;

import com.example.data.datasource.datastore.ParameterDataStoreFactory;
import com.example.data.repository.ParameterDataRepository;
import com.example.domain.model.Parameter;
import com.example.interactor.parameter.ParameterInteractor;
import com.example.interactor.parameter.ParameterListCallback;
import com.example.presentation.view.LoginView;

import java.util.List;

public class LoginPresenter implements
        Presenter<LoginView>,
        ParameterListCallback {

    private LoginView loginView;
    private ParameterInteractor parameterInteractor;

    @Override
    public void addView(LoginView view) {
        this.loginView = view;
        parameterInteractor =
                new ParameterInteractor(
                        new ParameterDataRepository(
                                new ParameterDataStoreFactory(
                                        this.loginView.getContext()
                                )));
    }

    @Override
    public void removeView(LoginView view) {
        this.loginView = null;
    }

    // region ParameterListCallback

    public void getAllParameter() {
        this.parameterInteractor.loadParameters(this);
    }

    @Override
    public void onParameterListSuccess(List<Parameter> parameterList) {
        this.loginView.parameterListSuccess(parameterList);
    }

    @Override
    public void onParameterListError(String message) {
        this.loginView.showErrorMessage(message);
    }

    // endregion
}

