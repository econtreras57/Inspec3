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

import java.util.ArrayList;
import java.util.List;


public class InspectionPresenter implements
        Presenter<InspectionView>,
        InspectionCreatedCallback,
        InspectionListCreatedCallback,
        InspectionUpdatedCallback,
        InspectionDeletedCallback,
        InspectionListCallback {

    private InspectionView inspectionView;
    private InspectionInteractor inspectionInteractor;

    public void createInspection(Inspection inspection, int inspectionDataLocation) {
        inspectionInteractor.createInspection(
                inspection,
                inspectionDataLocation,
                this);
    }

    public void createInspectionList(List<Inspection> inspectionList, int inspectionDataLocation) {
        inspectionInteractor.createInspectionList(
                inspectionList,
                inspectionDataLocation,
                this);
    }

    public void updateInspection(Inspection inspection, int inspectionDataLocation) {
        inspectionInteractor.updateInspection(
                inspection,
                inspectionDataLocation,
                this);
    }

    public void deleteInspection(Inspection inspection, int inspectionDataLocation) {

        inspectionInteractor.deleteInspection(
                inspection,
                inspectionDataLocation,
                this);
    }

    public void loadInspections(int inspectionDataLocation) {
        inspectionInteractor.loadInspections(
                inspectionDataLocation,
                this);
    }

    @Override
    public void addView(InspectionView view) {
        this.inspectionView = view;
        InspectionRepository requestRepository =
                new InspectionDataRepository(
                        new InspectionDataStoreFactory(this.inspectionView.getContext())
                );
        inspectionInteractor = new InspectionInteractor(requestRepository);
    }

    @Override
    public void removeView(InspectionView view) {

    }

    @Override
    public void onInspectionCreatedSuccess(Inspection inspection) {
        inspectionView.inspectionCreated(inspection);
    }

    @Override
    public void onInspectionCreatedError(String message) {

    }

    @Override
    public void onInspectionUpdatedSuccess(Inspection inspection) {
        inspectionView.inspectionUpdated(inspection);
    }

    @Override
    public void onInspectionUpdatedError(String message) {

    }

    @Override
    public void onInspectionDeletedSuccess(Inspection inspection) {
        inspectionView.inspectionDeleted(inspection);
    }

    @Override
    public void onInspectionDeletedError(String message) {

    }

    @Override
    public void onInspectionListSuccess(ArrayList<Inspection> inspectionList) {
        inspectionView.inspectionsListLoaded((ArrayList<Inspection>) inspectionList);
    }

    @Override
    public void onInspectionListError(String message) {

    }

    @Override
    public void onInspectionListCreatedSuccess(List<Inspection> inspectionList) {
        inspectionView.inspectionCreatedList(inspectionList);

    }

    @Override
    public void onInspectionListCreatedError(String message) {

    }
}
