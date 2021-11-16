package com.vigade.pizzeriabackend.controller;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class WelcomeController {
    
    @GetMapping
    public Flux<Integer> index() {
        return Flux.just(11,12,13,14,15,16);
    }
}