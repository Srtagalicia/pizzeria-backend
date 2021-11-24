package com.vigade.pizzeriabackend.core.exceptionHandlers;

import com.vigade.pizzeriabackend.core.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {
    
    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleException(NotFoundException exception) {
        return ResponseEntity.status(exception.getStatusCode()).body("Entity not found.");
    }
}
