package com.vigade.pizzeriabackend.repo;

import com.vigade.pizzeriabackend.domain.Ingredient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IIngredientRepo {
    Mono<Ingredient> register(Ingredient ingredient);

    Mono<Ingredient> modify(Ingredient ingredient);

    Flux<Ingredient> list();

    Mono<Ingredient> listById(Integer id);

    Mono<Void> delete(Integer id);

}
