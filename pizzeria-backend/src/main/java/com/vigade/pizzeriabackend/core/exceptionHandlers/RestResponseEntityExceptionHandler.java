package com.vigade.pizzeriabackend.core.exceptionHandlers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger;

    @Autowired
    public RestResponseEntityExceptionHandler(final Logger logger) {
        this.logger = logger;
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    protected ResponseEntity<Object> handleException(MethodArgumentNotValidException exception, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : exception.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        logger.warn(String.format("%s , StackTrace: %s", exception.getMessage(), exception.getStackTrace().toString()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}