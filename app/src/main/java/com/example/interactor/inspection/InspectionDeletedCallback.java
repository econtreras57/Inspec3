package com.example.interactor.inspection;

import com.example.domain.model.Inspection;

public interface InspectionDeletedCallback {
    void onInspectionDeletedSuccess(Inspection inspection);
    void onInspectionDeletedError(String message);
}
