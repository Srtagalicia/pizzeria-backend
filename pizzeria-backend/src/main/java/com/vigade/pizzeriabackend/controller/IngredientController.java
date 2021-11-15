package com.vigade.pizzeriabackend.controller;

import javax.validation.Valid;
import com.vigade.pizzeriabackend.application.IngredientApplication;
import com.vigade.pizzeriabackend.application.IngredientDTOInput;
import com.vigade.pizzeriabackend.application.IngredientDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public IngredientDTOOutput addIngredient(@Valid @RequestBody IngredientDTOInput ingredientDTOInput) {
		return this.ingredientApplication.add(ingredientDTOInput);
	}
}