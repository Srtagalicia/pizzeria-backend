package com.vigade.pizzeriabackend.infrastructure.ingredientInfrastructure;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.ingredientDomain.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientReactiveRepository extends ReactiveCrudRepository<Ingredient, UUID> {
    
}
