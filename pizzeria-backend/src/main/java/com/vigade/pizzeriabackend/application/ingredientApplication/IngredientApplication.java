package com.vigade.pizzeriabackend.application.ingredientApplication;

import reactor.core.publisher.Mono;

public interface IngredientApplication {
    Mono<IngredientDTOOutput> add(IngredientDTOInput dto);
}
