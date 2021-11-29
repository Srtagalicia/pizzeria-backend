package com.vigade.pizzeriabackend.core.exceptions;

import com.vigade.pizzeriabackend.core.baseClasses.HttpExceptionBase;
import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpExceptionBase {
    
    public NotFoundException() {
        this("Entity not found.");
    }

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}