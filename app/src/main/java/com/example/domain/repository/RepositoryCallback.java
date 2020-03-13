package com.example.domain.repository;

public interface RepositoryCallback {

    void onError(Object object);
    void onSuccess(Object object);
}
