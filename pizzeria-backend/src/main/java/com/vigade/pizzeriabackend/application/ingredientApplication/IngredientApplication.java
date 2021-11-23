package com.vigade.pizzeriabackend.application.ingredientApplication;

import reactor.core.publisher.Mono;

public interface IngredientApplication {
}
    public Mono<IngredientDTOOutput> add(IngredientDTOInput dto);
