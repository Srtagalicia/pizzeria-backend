package com.vigade.pizzeriabackend.infrastructure.ingredientInfrastructure;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.ingredientDomain.Ingredient;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientProjection;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

public interface IngredientReactiveRepository extends ReactiveCrudRepository<Ingredient, UUID> {
    
    @Query("SELECT id, name, price FROM ingredients WHERE :name IS NULL OR name LIKE CONCAT('%', :name, '%') LIMIT :limit OFFSET :offset;")
    @Transactional(readOnly = true)
    public Flux<IngredientProjection> findAllIngredients(@Param(value="name") String name, @Param(value="limit") Integer limit, @Param(value="offset") Integer offset);
}