package com.vigade.pizzeriabackend.infrastructure.ingredientInfrastructure;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.ingredientDomain.Ingredient;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientProjection;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {
    
    private IngredientReactiveRepository ingredientReactiveRepository;

    @Autowired
    public IngredientRepositoryImp(IngredientReactiveRepository ingredientReactiveRepository) {
        this.ingredientReactiveRepository = ingredientReactiveRepository;
    }

    @Override
    public Mono<Ingredient> add(Ingredient ingredient) {
        return this.ingredientReactiveRepository.save(ingredient);
    }

    @Override
    public Mono<Ingredient> findById(UUID id) {
        return this.ingredientReactiveRepository.findById(id);
    }

    @Override
    public Mono<Ingredient> update(Ingredient ingredient) {
        return this.ingredientReactiveRepository.save(ingredient);
    }

    @Override
    public Mono<Void> delete(Ingredient ingredient) {
        return this.ingredientReactiveRepository.delete(ingredient);
    }

    @Override
    public Flux<IngredientProjection> getAll(String name, Integer limit, Integer offset) {
        return this.ingredientReactiveRepository.findAllIngredients(name, limit, offset);
    }

    @Override
    public Mono<Boolean> existsByField(String name) {
        return Mono.sequenceEqual(this.ingredientReactiveRepository.existsByName(name), Mono.just(1));
    }
}