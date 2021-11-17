package com.vigade.pizzeriabackend.application;

import com.vigade.pizzeriabackend.domain.Ingredient;
import com.vigade.pizzeriabackend.infrastructure.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;

@Service
public class IngredientApplicationImp implements IngredientApplication {
    
    private IngredientRepository ingredientRepository;
    private ModelMapper modelMapper;

    @Autowired
    public IngredientApplicationImp(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<IngredientDTOOutput> add(IngredientDTOInput ingredientDTOInput) {
        Ingredient ingredient = modelMapper.map(ingredientDTOInput, Ingredient.class);
        ingredientRepository.save(ingredient);
        return Mono.just(modelMapper.map(ingredient, IngredientDTOOutput.class));
    }
}