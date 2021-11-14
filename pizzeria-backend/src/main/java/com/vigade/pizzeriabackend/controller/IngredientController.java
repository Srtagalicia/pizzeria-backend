package com.vigade.pizzeriabackend.controller;

import com.vigade.pizzeriabackend.model.Ingredient;
import com.vigade.pizzeriabackend.repo.IIngredientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // TODO: Use a service package instead of this to keep the SOLID principles sticked to the project
    @Autowired
    private IIngredientRepo repo;

    // listt all ingredients
    @GetMapping
    public Flux<Ingredient> list() {
        return repo.list();
    }

    // list one ingredient
    @GetMapping("/{id}")
    public Mono<Ingredient> listById(@PathVariable("id") Integer id) {
        return repo.listById(id);
    }

    // create an ingredient
    @PostMapping
    public Mono<Ingredient> register(@RequestBody Ingredient ingredient) {
        return repo.register(ingredient);
    }

    // modify an ingredient
    @PutMapping
    public Mono<Ingredient> modify(@RequestBody Ingredient ingredient) {
        return repo.register(ingredient);
    }

    // delete an ingredient
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id) {
        return repo.delete(id);
    }

}
