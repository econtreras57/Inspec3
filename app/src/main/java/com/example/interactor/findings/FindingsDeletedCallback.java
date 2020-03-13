package com.example.interactor.findings;

import com.example.domain.model.Findings;

public interface FindingsDeletedCallback {
    void onFindingsDeletedSuccess(Findings findings);
    void onFindingsDeletedError(String message);
}
