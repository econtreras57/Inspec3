package com.example.data.datasource.cloud.model;

public class ErrorWs {

    private String idOperation;
    private String code;
    private String message;

    public ErrorWs() {
        this.idOperation = "";
        this.code = "";
        this.message = "";
    }

    public ErrorWs(String idOperation, String code, String message) {
        this.idOperation = idOperation;
        this.code = code;
        this.message = message;
    }

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
