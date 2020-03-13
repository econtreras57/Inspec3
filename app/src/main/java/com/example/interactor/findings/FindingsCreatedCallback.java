package com.example.interactor.findings;

import com.example.domain.model.Findings;

public interface FindingsCreatedCallback {
    void onFindingsCreatedSuccess(Findings findings);
    void onFindingsCreatedError(String message);

}
