package com.example.data.datasource.cloud;

import androidx.room.TypeConverters;

import com.example.data.datasource.cloud.dao.ParameterCloudDAO;
import com.example.data.datasource.cloud.dao.ParameterValueCloudDAO;
import com.example.presentation.utils.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@TypeConverters({Converters.class}) // 2020-03-13 ecv: Según manual, para manejo type Date

//public abstract class CloudInspec3Instance {
public class CloudInspec3Instance {

    //    private static Retrofit retrofit;
//    private static final String BASE_URL = "http://192.168.0.6:3000"; // cambiar según configuración ip local
//    private static final String BASE_URL = "http://192.168.2.24:3000";
    private static final String BASE_URL = "https://my-json-server.typicode.com/econtreras57/jsonsrvtst01/";
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

        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                .build();

        OkHttpClient client = new OkHttpClient.Builder()
//                .addNetworkInterceptor(new StethoInterceptor())   // estaba comentado
                .addInterceptor(logging)

                .connectTimeout(1, TimeUnit.MINUTES)    // decía 10
                .readTimeout(1, TimeUnit.MINUTES)       // decía 10
                .writeTimeout(1, TimeUnit.MINUTES)

                .connectionSpecs(Collections.singletonList(spec))

                .build();
        return client;
    }


}
