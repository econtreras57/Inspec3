package com.example.presentation.presenter;

import com.example.data.datasource.datastore.FindingsDataStoreFactory;
import com.example.data.repository.FindingsDataRepository;
import com.example.domain.model.Findings;
import com.example.domain.repository.FindingsRepository;
import com.example.interactor.findings.FindingsCreatedCallback;
import com.example.interactor.findings.FindingsDeletedCallback;
import com.example.interactor.findings.FindingsInteractor;
import com.example.interactor.findings.FindingsListCallback;
import com.example.interactor.findings.FindingsListCreatedCallback;
import com.example.interactor.findings.FindingsUpdatedCallback;
import com.example.presentation.view.FindingsView;

import java.util.ArrayList;
import java.util.List;


public class FindingsPresenter implements
        Presenter<FindingsView>,
        FindingsCreatedCallback,
        FindingsListCreatedCallback,
        FindingsUpdatedCallback,
        FindingsDeletedCallback,
        FindingsListCallback {

    private FindingsView findingsView;
    private FindingsInteractor findingsInteractor;

    public void createFindings(Findings findings, int findingsDataLocation) {
        findingsInteractor.createFindings(
                findings,
                findingsDataLocation,
                this);
    }

    public void createFindingsList(List<Findings> findingsList, int findingsDataLocation) {
        findingsInteractor.createFindingsList(
                findingsList,
                findingsDataLocation,
                this);
    }

    public void updateFindings(Findings findings, int findingsDataLocation) {
        findingsInteractor.updateFindings(
                findings,
                findingsDataLocation,
                this);
    }

    public void deleteFindings(Findings findings, int findingsDataLocation) {

        findingsInteractor.deleteFindings(
                findings,
                findingsDataLocation,
                this);
    }

    public void loadFindingss(int findingsDataLocation) {
        findingsInteractor.loadFindingss(
                findingsDataLocation,
                this);
    }

    @Override
    public void addView(FindingsView view) {
        this.findingsView = view;
        FindingsRepository requestRepository =
                new FindingsDataRepository(
                        new FindingsDataStoreFactory(this.findingsView.getContext())
                );
        findingsInteractor = new FindingsInteractor(requestRepository);
    }

    @Override
    public void removeView(FindingsView view) {

    }

    @Override
    public void onFindingsCreatedSuccess(Findings findings) {
        findingsView.findingsCreated(findings);
    }

    @Override
    public void onFindingsCreatedError(String message) {

    }

    @Override
    public void onFindingsUpdatedSuccess(Findings findings) {
        findingsView.findingsUpdated(findings);
    }

    @Override
    public void onFindingsUpdatedError(String message) {

    }

    @Override
    public void onFindingsDeletedSuccess(Findings findings) {
        findingsView.findingsDeleted(findings);
    }

    @Override
    public void onFindingsDeletedError(String message) {

    }

    @Override
    public void onFindingsListSuccess(ArrayList<Findings> findingsList) {
        findingsView.findingssListLoaded((ArrayList<Findings>) findingsList);
    }

    @Override
    public void onFindingsListError(String message) {

    }

    @Override
    public void onFindingsListCreatedSuccess(List<Findings> findingsList) {
        findingsView.findingsCreatedList(findingsList);

    }

    @Override
    public void onFindingsListCreatedError(String message) {

    }
}

