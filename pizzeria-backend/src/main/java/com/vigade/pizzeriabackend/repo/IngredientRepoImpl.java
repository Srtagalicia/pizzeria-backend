package com.vigade.pizzeriabackend.repo;

import java.util.ArrayList;
import java.util.List;

import com.vigade.pizzeriabackend.controller.IngredientController;
import com.vigade.pizzeriabackend.domain.Ingredient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class IngredientRepoImpl implements IIngredientRepo {

    private static final Logger Log = LoggerFactory.getLogger(IngredientController.class);

    @Override
    public Mono<Ingredient> register(Ingredient ingredient) {
        // aquí va la inserción a la base de datos con un driver que sea reactivo
        // (mongodb) no usar JDBC
        Log.info(ingredient.toString());
        return Mono.just(ingredient);
    }

    @Override
    public Mono<Ingredient> modify(Ingredient ingredient) {
        Log.info(ingredient.toString());
        return Mono.just(ingredient);
    }

    @Override
    public Flux<Ingredient> list() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(1, "queso"));
        ingredients.add(new Ingredient(2, "jamon"));
        ingredients.add(new Ingredient(3, "tomate"));
        return Flux.fromIterable(ingredients);
    }

    @Override
    public Mono<Ingredient> listById(Integer id) {
        return Mono.just(new Ingredient(5, "oregano"));
    }

    @Override
    public Mono<Void> delete(Integer id) {
        // TODO Auto-generated method stub
        return Mono.empty();
    }

}
