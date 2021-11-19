package com.vigade.pizzeriabackend.controller;

import com.vigade.pizzeriabackend.application.ingredientApplication.IngredientApplication;
import com.vigade.pizzeriabackend.application.ingredientApplication.IngredientDTOInput;
import com.vigade.pizzeriabackend.application.ingredientApplication.IngredientDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Mono<IngredientDTOOutput> addIngredient(@RequestBody IngredientDTOInput ingredientDTOInput) {
        return this.ingredientApplication.add(ingredientDTOInput);
    }
}