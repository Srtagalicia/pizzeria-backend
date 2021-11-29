package com.vigade.pizzeriabackend.core.exceptionHandlers;

import com.vigade.pizzeriabackend.core.exceptions.BadRequestException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BadRequestExceptionHandler {

    private final Logger logger;

    @Autowired
    public BadRequestExceptionHandler(final Logger logger){
        this.logger = logger;
    }
    
    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<Object> handleException(BadRequestException exception, WebRequest request) {

        logger.warn(String.format("%s , StackTrace: %s", exception.getMessage(), exception.getStackTrace()));

        return ResponseEntity.status(exception.getStatusCode()).body(exception.getExceptions());
    }
}
