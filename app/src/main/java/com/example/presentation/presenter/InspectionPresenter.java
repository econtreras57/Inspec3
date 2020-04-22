package com.example.presentation.presenter;

import com.example.data.datasource.datastore.InspectionDataStoreFactory;
import com.example.data.datasource.datastore.ParameterValueDataStoreFactory;
import com.example.data.repository.InspectionDataRepository;
import com.example.data.repository.ParameterValueDataRepository;
import com.example.domain.model.Inspection;
import com.example.domain.model.Parameter;
import com.example.domain.model.ParameterValue;
import com.example.domain.repository.InspectionRepository;
import com.example.domain.repository.ParameterValueRepository;
import com.example.interactor.inspection.InspectionCreatedCallback;
import com.example.interactor.inspection.InspectionDeletedCallback;
import com.example.interactor.inspection.InspectionInteractor;
import com.example.interactor.inspection.InspectionListCallback;
import com.example.interactor.inspection.InspectionListCreatedCallback;
import com.example.interactor.inspection.InspectionUpdatedCallback;
import com.example.interactor.parameter.ParameterInteractor;
import com.example.interactor.parameter.ParameterListCallback;
import com.example.interactor.parametervalue.ParameterValueInteractor;
import com.example.interactor.parametervalue.ParameterValueListCallback;
import com.example.presentation.view.InspectionView;

import java.util.ArrayList;
import java.util.List;

import static com.example.data.datasource.datastore.ParameterValueDataStoreFactory.CLOUD;


public class InspectionPresenter implements
        Presenter<InspectionView>,
//        InspectionListCreatedCallback,
//        InspectionListCallback,
        InspectionCreatedCallback,
        InspectionUpdatedCallback,
        InspectionDeletedCallback,
        ParameterListCallback,
        ParameterValueListCallback {

    private InspectionView inspectionView;
    private InspectionInteractor inspectionInteractor;
    private ParameterInteractor parameterInteractor;
    private ParameterValueInteractor parameterValueInteractor;

    public void createInspection(Inspection inspection, int inspectionDataLocation) {
        inspectionInteractor.createInspection(
                inspection,
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

    public void readParameterValueList(String parameterId) {

        // Dónde se decide si se trae de CLOUD o LOCAL?
        int parameterValueDataLocation = CLOUD;

        this.parameterValueInteractor.loadParameterValues(
                parameterId,
                parameterValueDataLocation,
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

//        parameterValueInteractor =
//                new ParameterValueInteractor(
//                        new ParameterValueDataRepository(
//                                new ParameterValueDataStoreFactory(
//                                        this.inspectionView.getContext()
//                                )));

        ParameterValueRepository parameterValueRepository =
                new ParameterValueDataRepository(
                        new ParameterValueDataStoreFactory(
                                this.inspectionView.getContext()
                        )
                );
        parameterValueInteractor = new ParameterValueInteractor(parameterValueRepository);

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
    public void onParameterListSuccess(List<Parameter> parameterList) {

    }

    @Override
    public void onParameterListError(String message) {

    }

    @Override
    public void onParameterValueListSuccess(ArrayList<ParameterValue> parameterValueList) {
        inspectionView.parameterValueListSuccess(parameterValueList);
    }

    @Override
    public void onParameterValueListError(String message) {

    }

////    @Override
////    public void onInspectionListSuccess(ArrayList<Inspection> inspectionList) {
////        inspectionView.inspectionsListLoaded((ArrayList<Inspection>) inspectionList);
////    }
////
//    @Override
//    public void onInspectionListError(String message) {
//
//    }
//
//    @Override
//    public void onInspectionListCreatedSuccess(List<Inspection> inspectionList) {
//        inspectionView.inspectionCreatedList(inspectionList);
//
//    }
//
//    @Override
//    public void onInspectionListCreatedError(String message) {
//
//    }
}
