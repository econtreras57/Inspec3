package com.example.data.datasource.cloud;

import androidx.room.Dao;

import com.example.data.datasource.cloud.model.CloudParameterEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@Dao
public interface ApiClientInterface {

    // Create one
    @POST("/parameter/new")
    Call<CloudParameterEntity> createParameter(@Body CloudParameterEntity cloudParameterEntity);

    // Create batch // ToDo <-- por validar
    @POST("/parameter/new")
    Call<List<CloudParameterEntity>>
    createParameterList(@Body List<CloudParameterEntity> cloudParameterEntityList);

    // Read one
    @GET("/parameter/{parameter}")
    Call<CloudParameterEntity> getParameter(@Path("parameter") String parameterId);

    // Read batch
    @GET("/parameter")
    Call<List<CloudParameterEntity>> loadParameters();

    // Update one   <-- ToDo ¿y el "body"?
    @PUT("/parameter/{parameter}")
    Call<CloudParameterEntity> updateParameter(@Path("parameter") String parameterId,
                                               @Body CloudParameterEntity cloudParameterEntity);

    // Delete one
    @DELETE("/parameter/{parameter}")
    Call<Void> deleteParameter(@Path("parameter") String parameterId);

}
