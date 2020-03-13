package com.example.interactor.findings;

import com.example.domain.model.Findings;

import java.util.ArrayList;
import java.util.List;

public interface FindingsListCallback {
    void onFindingsListSuccess(ArrayList<Findings> findingsList);
    void onFindingsListError(String message);
}
