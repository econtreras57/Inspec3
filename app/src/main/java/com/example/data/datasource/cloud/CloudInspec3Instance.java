package com.example.data.datasource.cloud;

import androidx.room.TypeConverters;

import com.example.data.datasource.cloud.dao.ParameterCloudDAO;
import com.example.data.datasource.cloud.dao.ParameterValueCloudDAO;
import com.example.presentation.utils.Converters;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@TypeConverters({Converters.class}) // 2020-03-13 ecv: Según manual, para manejo type Date

public abstract class CloudInspec3Instance {

    private static Retrofit retrofit;
    private static final String BASE_URL = " http://localhost:3000/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public abstract ParameterCloudDAO parameterDAO();

    public abstract ParameterValueCloudDAO parameterValueDAO();


}
