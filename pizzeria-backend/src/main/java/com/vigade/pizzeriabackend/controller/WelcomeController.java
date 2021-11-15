package com.vigade.pizzeriabackend.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class WelcomeController {
    
    @GetMapping
    public String index() {
        return "Welcome to the App!";
    }
}