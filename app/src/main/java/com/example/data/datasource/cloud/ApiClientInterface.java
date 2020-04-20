package com.example.data.datasource.cloud;

import androidx.room.Dao;

import com.example.data.datasource.cloud.model.CloudParameterEntity;
import com.example.data.datasource.cloud.model.CloudParameterValueEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Dao
public interface ApiClientInterface {

    // region parameter CRUD functions
    // Create one
    @POST("parameter/new")
    Call<CloudParameterEntity> createParameter(@Body CloudParameterEntity cloudParameterEntity);

    // Create batch // ToDo <-- por validar
    @POST("parameter/new")
    Call<List<CloudParameterEntity>>
    createParameterList(@Body List<CloudParameterEntity> cloudParameterEntityList);

    // Read one
    @GET("parameter/{parameter}")
    Call<CloudParameterEntity> getParameter(@Path("parameter") String parameterId);

    // Read batch
    @GET("parameter")
    Call<List<CloudParameterEntity>> loadParameters();

    // Update one   <-- ToDo ¿y el "body"?
    @PUT("parameter/{parameter}")
    Call<CloudParameterEntity> updateParameter(@Path("parameter") String parameterId,
                                               @Body CloudParameterEntity cloudParameterEntity);

    // Delete one
    @DELETE("parameter/{parameter}")
    Call<Void> deleteParameter(@Path("parameter") String parameterId);

    // endregion

    // region parameter_value CRUD functions
    // Create one
    @POST("parameter_value/new")
    Call<CloudParameterValueEntity> createParameterValue(
            @Body CloudParameterValueEntity cloudParameterValueEntity);

    // Create batch // ToDo <-- por validar
    @POST("parameter_value/new")
    Call<List<CloudParameterValueEntity>>
    createParameterValueList(
            @Body List<CloudParameterValueEntity> cloudParameterValueEntityList);

    // Read one
    @GET("parameter_value/{id}")
    Call<CloudParameterValueEntity> getParameterValue(
            @Path("id") String parameterValueId);

// region Read batch; example: http://localhost:3000/parameter_value/?idParameter=TPIN
//
//    @GET("Search") //i.e https://api.test.com/Search?
//    Call<Products> getProducts(@Query("one") String one, @Query("two") String two,
//                               @Query("key") String key)
//
//    @GET("parameter_value/?idParameter={groupId}")    // funciona en navegador, pero no aquí
//    Call<List<CloudParameterValueEntity>> getListParameterValues(
//            @Path("groupId") String parameterId);
// endregion

    @GET("parameter_value/")
        // parameter_value/?
    Call<List<CloudParameterValueEntity>> getListParameterValues(
            @Query("idParameter") String parameterId
    );

    // Update one
    @PUT("parameter_value/{parameter}")
    Call<CloudParameterValueEntity> updateParameterValue(
            @Path("parameter") String parameterValueId,
            CloudParameterValueEntity cloudParameterValueEntity);

    // Delete one
    @DELETE("parameter_value/{parameter}")
    Call<Void> deleteParameterValue(@Path("parameter") String parameterValueId);

    // endregion

}
