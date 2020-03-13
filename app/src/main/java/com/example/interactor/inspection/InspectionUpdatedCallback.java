package com.example.interactor.inspection;

import com.example.domain.model.Inspection;

public interface InspectionUpdatedCallback {
    void onInspectionUpdatedSuccess(Inspection inspection);
    void onInspectionUpdatedError(String message);
}
