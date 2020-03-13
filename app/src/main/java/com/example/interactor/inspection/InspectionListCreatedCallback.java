package com.example.interactor.inspection;

import com.example.domain.model.Inspection;

import java.util.List;

public interface InspectionListCreatedCallback {
    void onInspectionListCreatedSuccess(List<Inspection> inspectionList);
    void onInspectionListCreatedError(String message);
}
