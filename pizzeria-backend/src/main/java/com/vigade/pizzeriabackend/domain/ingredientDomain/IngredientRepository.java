package com.vigade.pizzeriabackend.domain.ingredientDomain;

import java.util.UUID;
import com.vigade.pizzeriabackend.core.functionalInterfaces.FindById;
import reactor.core.publisher.Mono;

public interface IngredientRepository extends FindById<Ingredient, UUID> {
    public Mono<Ingredient> add(Ingredient ingredient);
    public Mono<Ingredient> update(Ingredient ingredient);
}