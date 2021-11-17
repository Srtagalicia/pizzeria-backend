package com.vigade.pizzeriabackend.controller;

import javax.validation.Valid;
import com.vigade.pizzeriabackend.application.IngredientApplication;
import com.vigade.pizzeriabackend.application.IngredientDTOInput;
import com.vigade.pizzeriabackend.application.IngredientDTOOutput;
import com.vigade.pizzeriabackend.domain.Ingredient;
import com.vigade.pizzeriabackend.infrastructure.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	
	private IngredientApplication ingredientApplication;

	@Autowired
	public IngredientController(IngredientApplication ingredientApplication) {
		this.ingredientApplication = ingredientApplication;
	}

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<IngredientDTOOutput> addIngredient(@Valid @RequestBody IngredientDTOInput ingredientDTOInput) {
        return ingredientApplication.add(ingredientDTOInput);
    }
}