package com.vigade.pizzeriabackend.infrastructure.ingredientInfrastructure;

import com.vigade.pizzeriabackend.domain.ingredientDomain.Ingredient;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

}