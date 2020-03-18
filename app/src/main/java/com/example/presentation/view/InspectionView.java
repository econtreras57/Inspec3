package com.example.presentation.view;

import com.example.domain.model.Inspection;

import java.util.ArrayList;
import java.util.List;


public interface InspectionView extends BaseView {

    void inspectionCreated(Inspection inspection);

//    void inspectionCreatedList(List<Inspection> inspectionList);

    void inspectionUpdated(Inspection inspection);

    void inspectionDeleted(Inspection inspection);

//    void inspectionsListLoaded(ArrayList<Inspection> inspections);

    void showErrorMessage(String message);
}
