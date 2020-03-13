package com.example.domain.repository;

import com.example.domain.model.Inspection;
import com.example.interactor.inspection.InspectionCreatedCallback;
import com.example.interactor.inspection.InspectionDeletedCallback;
import com.example.interactor.inspection.InspectionListCallback;
import com.example.interactor.inspection.InspectionListCreatedCallback;
import com.example.interactor.inspection.InspectionUpdatedCallback;

import java.util.List;

public interface InspectionRepository {
    void createInspection(
            Inspection inspection,
            int inspectionDataLocation,
            InspectionCreatedCallback inspectionCreatedCallback);

    void createInspectionList(
            List<Inspection> inspectionList,
            int inspectionDataLocation,
            InspectionListCreatedCallback inspectionListCreateCallback);   // 2020-02-10

    void updateInspection(
            Inspection inspection,
            int inspectionDataLocation,
            InspectionUpdatedCallback inspectionUpdatedCallback);

    void deleteInspection(
            Inspection inspection,
            int inspectionDataLocation,
            InspectionDeletedCallback inspectionDeletedCallback);

    void loadInspections(
            int inspectionDataLocation,
            final InspectionListCallback requestListCallback);
}
