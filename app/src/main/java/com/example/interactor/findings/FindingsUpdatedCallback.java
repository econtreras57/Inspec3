package com.example.interactor.findings;

import com.example.domain.model.Findings;

public interface FindingsUpdatedCallback {
    void onFindingsUpdatedSuccess(Findings findings);
    void onFindingsUpdatedError(String message);
}
