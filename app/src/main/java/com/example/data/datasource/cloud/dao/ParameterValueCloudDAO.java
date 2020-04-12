package com.example.data.datasource.cloud.dao;

import androidx.room.Dao;

import com.example.data.datasource.cloud.model.CloudParameterValueEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@Dao
public interface ParameterValueCloudDAO {

    // Create one
    @POST("parameter_value/new")
    Call<CloudParameterValueEntity> createParameter(@Body CloudParameterValueEntity parameterCloudEntity);

    // Create batch // ToDo <-- por validar
    @POST("parameter_value/new")
    Call<List<CloudParameterValueEntity>>
    createParameterList(@Body List<CloudParameterValueEntity> parameterCloudEntityList);

    // Read one
    @GET("parameter_value/{parameter}")
    Call<CloudParameterValueEntity> getParameter(@Path("parameter") String parameterValueId);

    // Read batch
    @GET("parameter_value")
    Call<List<CloudParameterValueEntity>> getAllParameters();

    // Update one
    @PUT("parameter_value/{parameter}")
    Call<CloudParameterValueEntity> updateParameter(@Path("parameter") String parameterValueId);

    // Delete one
    @DELETE("parameter_value/{parameter}")
    Call<Void> deleteParameter(@Path("parameter") String parameterValueId);


}
