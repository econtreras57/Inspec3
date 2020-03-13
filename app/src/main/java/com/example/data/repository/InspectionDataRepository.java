package com.example.data.repository;

import com.example.data.datasource.datastore.InspectionDataStore;
import com.example.data.datasource.datastore.InspectionDataStoreFactory;
import com.example.domain.model.Inspection;
import com.example.domain.repository.InspectionRepository;
import com.example.domain.repository.RepositoryCallback;
import com.example.interactor.inspection.InspectionCreatedCallback;
import com.example.interactor.inspection.InspectionDeletedCallback;
import com.example.interactor.inspection.InspectionListCallback;
import com.example.interactor.inspection.InspectionListCreatedCallback;
import com.example.interactor.inspection.InspectionUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class InspectionDataRepository implements InspectionRepository {

    private final InspectionDataStoreFactory inspectionDataStoreFactory;

    public InspectionDataRepository(
            InspectionDataStoreFactory inspectionDataStoreFactory) {
        this.inspectionDataStoreFactory = inspectionDataStoreFactory;
    }

    @Override
    public void createInspection(
            Inspection inspection,
            int inspectionDataLocation,
            final InspectionCreatedCallback inspectionCreatedCallback) {    // ¿final? 2020-03-12

        final InspectionDataStore inspectionDataStore = inspectionDataStoreFactory.create(
//                inspectionDataStoreFactory.CLOUD,
                inspectionDataLocation
//                FirebaseFirestore.getInstance()
        );

        inspectionDataStore.createInspection(inspection, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                inspectionCreatedCallback.onInspectionCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Inspection newUser = (Inspection) object;
                inspectionCreatedCallback.onInspectionCreatedSuccess(newUser);
            }
        });
    }

    @Override
    public void createInspectionList(
            List<Inspection> inspectionList,
            int inspectionDataLocation,
            final InspectionListCreatedCallback inspectionListCreateCallback) {

        final InspectionDataStore inspectionDataStore = inspectionDataStoreFactory.create(
//                inspectionDataStoreFactory.CLOUD,
                inspectionDataLocation
//                FirebaseFirestore.getInstance()
        );

        inspectionDataStore.createInspectionList(inspectionList, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                inspectionListCreateCallback.onInspectionListCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                List<Inspection> newInspectionList = (List<Inspection>) object;
                inspectionListCreateCallback.onInspectionListCreatedSuccess(newInspectionList);
            }
        });
    }

    @Override
    public void updateInspection(
            Inspection inspection,
            int inspectionDataLocation,
            final InspectionUpdatedCallback inspectionUpdatedCallback) {

        final InspectionDataStore inspectionDataStore = inspectionDataStoreFactory.create(
//                inspectionDataStoreFactory.CLOUD,
                inspectionDataLocation
//                FirebaseFirestore.getInstance()
        );

        inspectionDataStore.updateInspection(inspection, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                inspectionUpdatedCallback.onInspectionUpdatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Inspection updInspection = (Inspection) object;
                inspectionUpdatedCallback.onInspectionUpdatedSuccess(updInspection);
            }
        });

    }

    @Override
    public void deleteInspection(
            Inspection inspection,
            int inspectionDataLocation,
            final InspectionDeletedCallback inspectionDeletedCallback) {

        final InspectionDataStore inspectionDataStore;

        inspectionDataStore = inspectionDataStoreFactory.create(
                inspectionDataLocation
//                FirebaseFirestore.getInstance()
        );

        inspectionDataStore.deleteInspection(inspection, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                inspectionDeletedCallback.onInspectionDeletedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                Inspection updInspection = (Inspection) object;
                inspectionDeletedCallback.onInspectionDeletedSuccess(updInspection);
            }
        });

    }

    @Override
    public void loadInspections(
            int inspectionDataLocation,
            final InspectionListCallback requestListCallback) {

        final InspectionDataStore inspectionDataStore = inspectionDataStoreFactory.create(
//                inspectionDataStoreFactory.CLOUD, FirebaseFirestore.getInstance());
                inspectionDataLocation
//                FirebaseFirestore.getInstance()
        );

        inspectionDataStore.inspectionsList(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                requestListCallback.onInspectionListError(message);
            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<Inspection> inspectionArrayList = (ArrayList<Inspection>) object;
                requestListCallback.onInspectionListSuccess(inspectionArrayList);
            }
        });


    }
    
}
