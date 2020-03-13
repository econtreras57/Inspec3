package com.example.data.repository;

import com.example.data.datasource.datastore.FindingsDataStore;
import com.example.data.datasource.datastore.FindingsDataStoreFactory;
import com.example.domain.model.Findings;
import com.example.domain.repository.FindingsRepository;
import com.example.domain.repository.RepositoryCallback;
import com.example.interactor.findings.FindingsCreatedCallback;
import com.example.interactor.findings.FindingsDeletedCallback;
import com.example.interactor.findings.FindingsListCallback;
import com.example.interactor.findings.FindingsListCreatedCallback;
import com.example.interactor.findings.FindingsUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class FindingsDataRepository implements FindingsRepository {

    private final FindingsDataStoreFactory findingsDataStoreFactory;

    public FindingsDataRepository(
            FindingsDataStoreFactory findingsDataStoreFactory) {
        this.findingsDataStoreFactory = findingsDataStoreFactory;
    }

    @Override
    public void createFindings(
            Findings findings,
            int findingsDataLocation,
            final FindingsCreatedCallback findingsCreatedCallback) {    // ¿final? 2020-03-12

        final FindingsDataStore findingsDataStore = findingsDataStoreFactory.create(
//                findingsDataStoreFactory.CLOUD,
                findingsDataLocation
//                FirebaseFirestore.getInstance()
        );

        findingsDataStore.createFindings(findings, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                findingsCreatedCallback.onFindingsCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Findings newUser = (Findings) object;
                findingsCreatedCallback.onFindingsCreatedSuccess(newUser);
            }
        });
    }

    @Override
    public void createFindingsList(
            List<Findings> findingsList,
            int findingsDataLocation,
            final FindingsListCreatedCallback findingsListCreateCallback) {

        final FindingsDataStore findingsDataStore = findingsDataStoreFactory.create(
//                findingsDataStoreFactory.CLOUD,
                findingsDataLocation
//                FirebaseFirestore.getInstance()
        );

        findingsDataStore.createFindingsList(findingsList, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                findingsListCreateCallback.onFindingsListCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                List<Findings> newFindingsList = (List<Findings>) object;
                findingsListCreateCallback.onFindingsListCreatedSuccess(newFindingsList);
            }
        });
    }

    @Override
    public void updateFindings(
            Findings findings,
            int findingsDataLocation,
            final FindingsUpdatedCallback findingsUpdatedCallback) {

        final FindingsDataStore findingsDataStore = findingsDataStoreFactory.create(
//                findingsDataStoreFactory.CLOUD,
                findingsDataLocation
//                FirebaseFirestore.getInstance()
        );

        findingsDataStore.updateFindings(findings, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                findingsUpdatedCallback.onFindingsUpdatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Findings updFindings = (Findings) object;
                findingsUpdatedCallback.onFindingsUpdatedSuccess(updFindings);
            }
        });

    }

    @Override
    public void deleteFindings(
            Findings findings,
            int findingsDataLocation,
            final FindingsDeletedCallback findingsDeletedCallback) {

        final FindingsDataStore findingsDataStore;

        findingsDataStore = findingsDataStoreFactory.create(
                findingsDataLocation
//                FirebaseFirestore.getInstance()
        );

        findingsDataStore.deleteFindings(findings, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                findingsDeletedCallback.onFindingsDeletedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Findings updFindings = (Findings) object;
                findingsDeletedCallback.onFindingsDeletedSuccess(updFindings);
            }
        });

    }

    @Override
    public void loadFindings(
            int findingsDataLocation,
            final FindingsListCallback requestListCallback) {

        final FindingsDataStore findingsDataStore = findingsDataStoreFactory.create(
//                findingsDataStoreFactory.CLOUD, FirebaseFirestore.getInstance());
                findingsDataLocation
//                FirebaseFirestore.getInstance()
        );

        findingsDataStore.findingssList(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                requestListCallback.onFindingsListError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<Findings> findingsArrayList = (ArrayList<Findings>) object;
                requestListCallback.onFindingsListSuccess(findingsArrayList);
            }
        });


    }

}
