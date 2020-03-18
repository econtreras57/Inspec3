package com.example.presentation.presenter;

import com.example.data.datasource.datastore.InspectionDataStoreFactory;
import com.example.data.repository.InspectionDataRepository;
import com.example.domain.model.Inspection;
import com.example.domain.repository.InspectionRepository;
import com.example.interactor.inspection.InspectionCreatedCallback;
import com.example.interactor.inspection.InspectionDeletedCallback;
import com.example.interactor.inspection.InspectionInteractor;
import com.example.interactor.inspection.InspectionListCallback;
import com.example.interactor.inspection.InspectionListCreatedCallback;
import com.example.interactor.inspection.InspectionUpdatedCallback;
import com.example.presentation.view.InspectionView;
import com.example.presentation.view.ListInspectionsView;

import java.util.ArrayList;
import java.util.List;


public class ListInspectionsPresenter implements
        Presenter<ListInspectionsView>,
        InspectionListCreatedCallback,
        InspectionListCallback {

    private ListInspectionsView listInspectionsView;
    private InspectionInteractor inspectionInteractor;

    public void createInspectionList(List<Inspection> inspectionList, int inspectionDataLocation) {
        inspectionInteractor.createInspectionList(
                inspectionList,
                inspectionDataLocation,
                this);
    }

    public void loadInspections(int inspectionDataLocation) {
        inspectionInteractor.loadInspections(
                inspectionDataLocation,
                this);
    }

    @Override
    public void addView(ListInspectionsView view) {
        this.listInspectionsView = view;
        InspectionRepository requestRepository =
                new InspectionDataRepository(
                        new InspectionDataStoreFactory(this.listInspectionsView.getContext())
                );
        inspectionInteractor = new InspectionInteractor(requestRepository);
    }

    @Override
    public void removeView(ListInspectionsView view) {

    }

    @Override
    public void onInspectionListSuccess(ArrayList<Inspection> inspectionList) {
        listInspectionsView.inspectionsListLoaded((ArrayList<Inspection>) inspectionList);
    }

    @Override
    public void onInspectionListError(String message) {

    }

    @Override
    public void onInspectionListCreatedSuccess(List<Inspection> inspectionList) {
        listInspectionsView.inspectionCreatedList(inspectionList);

    }

    @Override
    public void onInspectionListCreatedError(String message) {

    }

}
