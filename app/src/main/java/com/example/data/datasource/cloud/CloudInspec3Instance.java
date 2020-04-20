package com.example.data.datasource.cloud;

import androidx.room.TypeConverters;

import com.example.data.datasource.cloud.dao.ParameterCloudDAO;
import com.example.data.datasource.cloud.dao.ParameterValueCloudDAO;
import com.example.presentation.utils.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@TypeConverters({Converters.class}) // 2020-03-13 ecv: Según manual, para manejo type Date

public abstract class CloudInspec3Instance {

    //    private static Retrofit retrofit;
//    private static final String BASE_URL = "http://192.168.0.6:3000"; // cambiar según configuración ip local
//    private static final String BASE_URL = "http://localhost:3000";
//    private static final String BASE_URL = "http://192.168.2.24:3000";
    private static final String BASE_URL = "https://my-json-server.typicode.com/econtreras57/";
//
//    public static Retrofit getRetrofitInstance() {
//        if (retrofit == null) {
//            retrofit = new retrofit2.Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//
//    public abstract ParameterCloudDAO parameterDAO();
//
//    public abstract ParameterValueCloudDAO parameterValueDAO();

    // region

    private static ApiClientInterface apiClientInterface;

    public static ApiClientInterface getApiClient() {

        Gson gson = new GsonBuilder().serializeNulls().create();


        if (apiClientInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiClientInterface = retrofit.create(ApiClientInterface.class);
        }
        return apiClientInterface;
    }

    private static OkHttpClient getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(logging)
//                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        return client;
    }


}
