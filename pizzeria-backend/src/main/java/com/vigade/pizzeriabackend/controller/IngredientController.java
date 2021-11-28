package com.vigade.pizzeriabackend.controller;

import java.util.UUID;
import com.vigade.pizzeriabackend.application.ingredientApplication.IngredientApplication;
import com.vigade.pizzeriabackend.application.ingredientApplication.IngredientDTOInput;
import com.vigade.pizzeriabackend.application.ingredientApplication.IngredientDTOOutput;
import com.vigade.pizzeriabackend.domain.ingredientDomain.IngredientProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

	private IngredientApplication ingredientApplication;

	@Autowired
	public IngredientController(IngredientApplication ingredientApplication) {
		this.ingredientApplication = ingredientApplication;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<IngredientDTOOutput> add(@Valid @RequestBody IngredientDTOInput ingredientDTOInput) {
		return this.ingredientApplication.add(ingredientDTOInput);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<IngredientDTOOutput> get(@PathVariable UUID id) {
		return this.ingredientApplication.get(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> update(@PathVariable UUID id, @Valid @RequestBody IngredientDTOInput ingredientDTOInput) {
		return this.ingredientApplication.update(id, ingredientDTOInput);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable UUID id) {
		return this.ingredientApplication.delete(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Flux<IngredientProjection> getAll(
			@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "10") Integer limit,
			@RequestParam(defaultValue = "0") Integer offset) {
		return this.ingredientApplication.getAll(name, limit, offset);
	}
}