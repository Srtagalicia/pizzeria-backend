package com.vigade.pizzeriabackend.core.exceptions;

import java.util.HashMap;
import java.util.Map;

import com.vigade.pizzeriabackend.core.baseClasses.HttpExceptionBase;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends HttpExceptionBase {
    
    private final Map<String, String> map = new HashMap<String, String>();

     public ForbiddenException(){
         this("Forbidden");
     } 
     public ForbiddenException(String message){
         super(HttpStatus.FORBIDDEN, message);
     }
     public Map<String,String> getExceptions(){
        return this.map;
    }

    public void addException(String key, String message){
        this.map.put(key, message);
    }
}