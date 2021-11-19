package com.vigade.pizzeriabackend.core.exceptionsHandlers;

import com.vigade.pizzeriabackend.core.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundConflict(NotFoundException ex, WebRequest request) {
        return ResponseEntity.status(ex.getCode()).body("Error 404");
    }
}
