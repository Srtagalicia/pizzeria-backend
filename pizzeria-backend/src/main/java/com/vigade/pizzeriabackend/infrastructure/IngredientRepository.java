package com.vigade.pizzeriabackend.infrastructure;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, UUID> {
    
}