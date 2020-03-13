package com.example.interactor.inspection;

import com.example.domain.model.Inspection;

public interface InspectionCreatedCallback {
    void onInspectionCreatedSuccess(Inspection inspection);
    void onInspectionCreatedError(String message);

}
