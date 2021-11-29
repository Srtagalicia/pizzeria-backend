package com.vigade.pizzeriabackend.application.ingredientApplication;

import java.util.UUID;
import com.vigade.pizzeriabackend.core.baseClasses.ApplicationBase;
import com.vigade.pizzeriabackend.domain.ingredientDomain.Ingredient;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientProjection;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private IngredientRepository ingredientRepository;
    private ModelMapper modelMapper;
    private Logger logger;

    @Autowired
    public IngredientApplicationImp (
        IngredientRepository ingredientRepository, 
        ModelMapper modelMapper, 
        Logger logger
    ) {
        super(id -> ingredientRepository.findById(id));
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }

    @Override
    public Mono<IngredientDTOOutput> add(IngredientDTOInput ingredientDTOInput) {
        Ingredient ingredient = this.modelMapper.map(ingredientDTOInput, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
        return ingredient.validate("name", ingredient.getName(), name -> this.ingredientRepository.existsByField(name))
                .then(this.ingredientRepository.add(ingredient).flatMap(monoIngredient -> {
                    logger.info(this.serializeObject(monoIngredient, "Added Ingredient"));
                    return Mono.just(this.modelMapper.map(monoIngredient, IngredientDTOOutput.class));
                }));
    }

    @Override
    public Mono<IngredientDTOOutput> get(UUID id) {
        return this.getById(id)
                .flatMap(monoIngredient -> Mono.just(this.modelMapper.map(monoIngredient, IngredientDTOOutput.class)));
    }

    @Override
    public Mono<Void> update(UUID id, IngredientDTOInput ingredientDTOInput) {
        return this.getById(id).flatMap(monoIngredient -> {
            if (monoIngredient.getName().equals(ingredientDTOInput.getName())) {
                this.modelMapper.map(ingredientDTOInput, monoIngredient);
                monoIngredient.validate();
                return this.ingredientRepository.update(monoIngredient).flatMap(updatedMonoIngredient -> {
                    logger.info(this.serializeObject(updatedMonoIngredient, "Update Ingredient"));
                    return Mono.empty();
                });
            }
            this.modelMapper.map(ingredientDTOInput, monoIngredient);
            return monoIngredient.validate("name", monoIngredient.getName(), name -> this.ingredientRepository.existsByField(name))
                .then(this.ingredientRepository.update(monoIngredient)).flatMap(updatedMonoIngredient -> {
                    logger.info(this.serializeObject(updatedMonoIngredient, "Update Ingredient"));
                    return Mono.empty();
                });
        });
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return this.getById(id).flatMap(monoIngredient -> {
            return this.ingredientRepository.delete(monoIngredient).flatMap(deletedMonoIngredient -> {
                    logger.info(this.serializeObject(monoIngredient, "Delete Ingredient"));
                    return Mono.empty();
                });
        });
    }

    @Override
    public Flux<IngredientProjection> getAll(String name, Integer limit, Integer offset) {
        return this.ingredientRepository.getAll(name, limit, offset);
    }
}