package com.example.interactor.inspection;

import com.example.domain.model.Inspection;
import com.example.domain.repository.InspectionRepository;

import java.util.List;

public class InspectionInteractor {

    private final InspectionRepository inspectionRepository;

    public InspectionInteractor(InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    public void createInspection(
            Inspection inspection,
            int inspectionDataLocation,
            InspectionCreatedCallback inspectionCreatedCallback
    ) {
        inspectionRepository.createInspection(
                inspection,
                inspectionDataLocation,
                inspectionCreatedCallback);
    }

    public void createInspectionList(
            List<Inspection> inspectionList,
            int inspectionDataLocation,
            InspectionListCreatedCallback inspectionListCreatedCallback
    ) {
        inspectionRepository.createInspectionList(
                inspectionList,
                inspectionDataLocation,
                inspectionListCreatedCallback);
    }

    public void updateInspection(
            Inspection inspection,
            int inspectionDataLocation,
            InspectionUpdatedCallback inspectionUpdatedCallback
    ) {
        inspectionRepository.updateInspection(
                inspection,
                inspectionDataLocation,
                inspectionUpdatedCallback);
    }

    public void deleteInspection(
            Inspection inspection,
            int inspectionDataLocation,
            InspectionDeletedCallback inspectionDeletedCallback) {

        inspectionRepository.deleteInspection(
                inspection,
                inspectionDataLocation,
                inspectionDeletedCallback);
    }

    public void loadInspections(
            int inspectionDataLocation,
            InspectionListCallback inspectionListCallback) {
        inspectionRepository.loadInspections(
                inspectionDataLocation,
                inspectionListCallback);
    }
    
}
