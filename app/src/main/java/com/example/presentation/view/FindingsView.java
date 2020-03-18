package com.example.presentation.view;

import com.example.domain.model.Findings;

import java.util.ArrayList;
import java.util.List;


public interface FindingsView extends BaseView {

//    void findingsCreatedList(List<Findings> findingsList);

//    void findingssListLoaded(ArrayList<Findings> findingss);

    void findingsCreated(Findings findings);

    void findingsUpdated(Findings findings);

    void findingsDeleted(Findings findings);

    void showErrorMessage(String message);
}
