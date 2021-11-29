package com.vigade.pizzeriabackend.core.exceptionHandlers;

import com.vigade.pizzeriabackend.core.exceptions.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadRequestExceptionHandler {
    
    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<Object> handleException(BadRequestException exception) {
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getExceptions());
    }
}