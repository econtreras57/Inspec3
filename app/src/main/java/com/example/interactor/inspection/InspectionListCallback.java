package com.example.interactor.inspection;

import com.example.domain.model.Inspection;

import java.util.ArrayList;
import java.util.List;

public interface InspectionListCallback {
    void onInspectionListSuccess(ArrayList<Inspection> inspectionList);
    void onInspectionListError(String message);
}
