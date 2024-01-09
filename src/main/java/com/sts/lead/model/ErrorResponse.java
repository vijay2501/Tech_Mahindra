package com.sts.lead.model;



public class ErrorResponse {

    private String code;
    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // Getter methods for code and message

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

