package com.vigade.pizzeriabackend.controller;

import com.vigade.pizzeriabackend.domain.Ingredient;
import com.vigade.pizzeriabackend.infrastructure.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	
	IngredientRepository ingredientRepository;
	
	@Autowired
	public IngredientController(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	@PostMapping
	public @ResponseBody Ingredient addIngredient(@RequestBody Ingredient ingredient) {
		ingredientRepository.save(ingredient);
		return ingredient;
	}
}