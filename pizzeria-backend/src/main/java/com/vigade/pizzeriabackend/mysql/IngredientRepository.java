package com.vigade.pizzeriabackend.mysql;

import java.util.UUID;

import com.vigade.pizzeriabackend.domain.Ingredient;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, Integer> {
    
}
