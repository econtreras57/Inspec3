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
import com.example.presentation.view.ListFindingsView;

import java.util.ArrayList;
import java.util.List;


public class ListFindingsPresenter implements
        Presenter<ListFindingsView>,
        FindingsListCreatedCallback,
        FindingsListCallback {

    private ListFindingsView listFindingsView;
    private FindingsInteractor findingsInteractor;

    public void createFindingsList(List<Findings> findingsList, int findingsDataLocation) {
        findingsInteractor.createFindingsList(
                findingsList,
                findingsDataLocation,
                this);
    }

    public void loadFindings(int findingsDataLocation) {
        findingsInteractor.loadFindingss(
                findingsDataLocation,
                this);
    }

    @Override
    public void addView(ListFindingsView view) {
        this.listFindingsView = view;
        FindingsRepository requestRepository =
                new FindingsDataRepository(
                        new FindingsDataStoreFactory(this.listFindingsView.getContext())
                );
        findingsInteractor = new FindingsInteractor(requestRepository);
    }

    @Override
    public void removeView(ListFindingsView view) {

    }

    @Override
    public void onFindingsListSuccess(ArrayList<Findings> findingsList) {
        listFindingsView.findingssListLoaded((ArrayList<Findings>) findingsList);
    }

    @Override
    public void onFindingsListError(String message) {

    }

    @Override
    public void onFindingsListCreatedSuccess(List<Findings> findingsList) {
        listFindingsView.findingsCreatedList(findingsList);

    }

    @Override
    public void onFindingsListCreatedError(String message) {

    }

}
