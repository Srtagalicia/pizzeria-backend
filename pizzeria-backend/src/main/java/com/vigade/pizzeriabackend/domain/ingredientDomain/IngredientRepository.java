package com.vigade.pizzeriabackend.domain.ingredientDomain;

import reactor.core.publisher.Mono;

public interface IngredientRepository {
    public Mono<Ingredient> add(Ingredient ingredient);
}