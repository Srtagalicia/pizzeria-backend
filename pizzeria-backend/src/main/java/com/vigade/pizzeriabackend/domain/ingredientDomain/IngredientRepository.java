package com.vigade.pizzeriabackend.domain.ingredientDomain;

import reactor.core.publisher.Mono;

public interface IngredientRepository {
    Mono<Ingredient> add(Ingredient ingredient);
}