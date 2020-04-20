package com.example.presentation.view;

import com.example.domain.model.Inspection;
import com.example.domain.model.ParameterValue;

import java.util.ArrayList;
import java.util.List;


public interface InspectionView extends BaseView {

    void parameterValueListSuccess(List<ParameterValue> parameterValues);

    void inspectionCreated(Inspection inspection);

//    void inspectionCreatedList(List<Inspection> inspectionList);

    void inspectionUpdated(Inspection inspection);

    void inspectionDeleted(Inspection inspection);

//    void inspectionsListLoaded(ArrayList<Inspection> inspections);

    void showErrorMessage(String message);
}
