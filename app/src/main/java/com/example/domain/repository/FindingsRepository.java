package com.example.domain.repository;

import com.example.domain.model.Findings;
import com.example.interactor.findings.FindingsCreatedCallback;
import com.example.interactor.findings.FindingsDeletedCallback;
import com.example.interactor.findings.FindingsListCallback;
import com.example.interactor.findings.FindingsListCreatedCallback;
import com.example.interactor.findings.FindingsUpdatedCallback;

import java.util.List;

public interface FindingsRepository {
    void createFindings(
            Findings findings,
            int findingsDataLocation,
            FindingsCreatedCallback findingsCreatedCallback);

    void createFindingsList(
            List<Findings> findingsList,
            int findingsDataLocation,
            FindingsListCreatedCallback findingsListCreateCallback);   // 2020-02-10

    void updateFindings(
            Findings findings,
            int findingsDataLocation,
            FindingsUpdatedCallback findingsUpdatedCallback);

    void deleteFindings(
            Findings findings,
            int findingsDataLocation,
            FindingsDeletedCallback findingsDeletedCallback);

    void loadFindings(
            int findingsDataLocation,
            final FindingsListCallback requestListCallback);
}
