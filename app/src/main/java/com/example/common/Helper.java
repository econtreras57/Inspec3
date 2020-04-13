package com.example.common;

import com.example.data.datasource.cloud.model.ErrorWs;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Response;

public class Helper {

    public static ErrorWs getWsErrorResponse(Response<?> response) {
        ErrorWs error = new ErrorWs();
        error.setMessage("Error");
        try {
            JSONObject json = new JSONObject(response.errorBody().string());
            error.setIdOperation(json.getString("IdOperacion"));
            error.setMessage(json.getString("Mensaje"));
            error.setCode(json.getString("Codigo"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return error;
    }

    public static ErrorWs getWsErrorResponse(String response) {
        ErrorWs error = new ErrorWs();
        error.setMessage(response);
        return error;
    }

}
