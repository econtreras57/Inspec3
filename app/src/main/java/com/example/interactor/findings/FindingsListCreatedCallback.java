package com.example.interactor.findings;

import com.example.domain.model.Findings;

import java.util.List;

public interface FindingsListCreatedCallback {
    void onFindingsListCreatedSuccess(List<Findings> findingsList);
    void onFindingsListCreatedError(String message);
}
