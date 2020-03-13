package com.example.presentation.view;

import com.example.domain.model.Findings;

import java.util.ArrayList;
import java.util.List;


public interface FindingsView extends BaseView {

    void findingsCreated(Findings findings);

    void findingsCreatedList(List<Findings> findingsList);

    void findingsUpdated(Findings findings);

    void findingsDeleted(Findings findings);

    void findingssListLoaded(ArrayList<Findings> findingss);

    void showErrorMessage(String message);
}
