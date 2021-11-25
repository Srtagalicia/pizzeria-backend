package com.vigade.pizzeriabackend.core.exceptions;

import java.util.HashMap;
import java.util.Map;
import com.vigade.pizzeriabackend.core.baseClasses.HttpExceptionBase;
import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpExceptionBase {
    
    private Map<String, String> exceptions = new HashMap<>();

    public BadRequestException() {
        this("Bad Request.");
    }

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    public Map<String, String> getExceptions() {
        return this.exceptions;
    }

    public void addException(String key, String message) {
        this.exceptions.put(key, message);
    }
}
