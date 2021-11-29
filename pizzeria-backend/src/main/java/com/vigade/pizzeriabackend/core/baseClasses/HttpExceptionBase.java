package com.vigade.pizzeriabackend.core.baseClasses;

import org.springframework.http.HttpStatus;

public class HttpExceptionBase extends RuntimeException {
    
    private HttpStatus statusCode;

    public HttpExceptionBase(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }
}