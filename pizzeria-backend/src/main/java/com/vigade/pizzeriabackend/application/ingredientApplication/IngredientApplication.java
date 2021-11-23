package com.vigade.pizzeriabackend.application.ingredientApplication;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientProjection;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientApplication {
    public Mono<IngredientDTOOutput> add(IngredientDTOInput dto);
    public Mono<IngredientDTOOutput> get(UUID id);
    public Mono<IngredientDTOOutput> update(UUID id, IngredientDTOInput dto);
    public Mono<Void> delete(UUID id);
    public Flux<IngredientProjection> getAll();
}