package com.vigade.pizzeriabackend.domain.ingredientDomain;

import java.util.UUID;
import com.vigade.pizzeriabackend.core.functionalInterfaces.FindById;
import com.vigade.pizzeriabackend.core.functionalInterfaces.ExistsByField;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientRepository extends FindById<Ingredient, UUID>, ExistsByField {
    public Mono<Ingredient> add(Ingredient ingredient);
    public Mono<Ingredient> update(Ingredient ingredient);
    public Mono<Void> delete(Ingredient ingredient);
    public Flux<IngredientProjection> getAll(String name, Integer limit, Integer offset);
}