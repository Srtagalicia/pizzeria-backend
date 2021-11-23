package com.vigade.pizzeriabackend.application.ingredientApplication;

import java.util.UUID;
import com.vigade.pizzeriabackend.core.baseClasses.ApplicationBase;
import com.vigade.pizzeriabackend.domain.ingredientDomain.Ingredient;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;

@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {
    
    private IngredientRepository ingredientRepository;
    private ModelMapper modelMapper;

    @Autowired
    public IngredientApplicationImp(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        super(id -> ingredientRepository.findById(id));
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<IngredientDTOOutput> add(IngredientDTOInput ingredientDTOInput) {
        Ingredient ingredient = this.modelMapper.map(ingredientDTOInput, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
        return this.ingredientRepository.add(ingredient).flatMap(monoIngredient -> Mono.just(this.modelMapper.map(monoIngredient, IngredientDTOOutput.class)));
    }

    @Override
    public Mono<IngredientDTOOutput> get(UUID id) {
        return this.getById(id).flatMap(monoIngredient -> Mono.just(this.modelMapper.map(monoIngredient, IngredientDTOOutput.class)));
    }
    }
}