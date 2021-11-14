package com.vigade.pizzeriabackend.controller;

import com.vigade.pizzeriabackend.model.Ingredient;
import com.vigade.pizzeriabackend.repo.IIngredientRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private static final Logger Log = LoggerFactory.getLogger(IngredientController.class);

    //usar un paquete service
    @Autowired
    private IIngredientRepo repo;
    //retorno de datos, por eso usamos el @getmapping
    @GetMapping
    public Flux<Ingredient> list() {
        return repo.list();
    }
    //para registrar ingredientes
    @PostMapping
    public Mono<Ingredient> register(@RequestBody Ingredient ingredient) {
        return repo.register(ingredient);
    }
    @PutMapping
    public Mono<Ingredient> modify(@RequestBody Ingredient ingredient) {
        return repo.register(ingredient);
    }
    
}
