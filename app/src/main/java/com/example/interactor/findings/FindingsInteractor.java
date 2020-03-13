package com.example.interactor.findings;

import com.example.domain.model.Findings;
import com.example.domain.repository.FindingsRepository;

import java.util.List;

public class FindingsInteractor {

    private final FindingsRepository findingsRepository;

    public FindingsInteractor(FindingsRepository findingsRepository) {
        this.findingsRepository = findingsRepository;
    }

    public void createFindings(
            Findings findings,
            int findingsDataLocation,
            FindingsCreatedCallback findingsCreatedCallback
    ) {
        findingsRepository.createFindings(
                findings,
                findingsDataLocation,
                findingsCreatedCallback);
    }

    public void createFindingsList(
            List<Findings> findingsList,
            int findingsDataLocation,
            FindingsListCreatedCallback findingsListCreatedCallback
    ) {
        findingsRepository.createFindingsList(
                findingsList,
                findingsDataLocation,
                findingsListCreatedCallback);
    }

    public void updateFindings(
            Findings findings,
            int findingsDataLocation,
            FindingsUpdatedCallback findingsUpdatedCallback
    ) {
        findingsRepository.updateFindings(
                findings,
                findingsDataLocation,
                findingsUpdatedCallback);
    }

    public void deleteFindings(
            Findings findings,
            int findingsDataLocation,
            FindingsDeletedCallback findingsDeletedCallback) {

        findingsRepository.deleteFindings(
                findings,
                findingsDataLocation,
                findingsDeletedCallback);
    }

    public void loadFindingss(
            int findingsDataLocation,
            FindingsListCallback findingsListCallback) {
        findingsRepository.loadFindings(
                findingsDataLocation,
                findingsListCallback);
    }

}
