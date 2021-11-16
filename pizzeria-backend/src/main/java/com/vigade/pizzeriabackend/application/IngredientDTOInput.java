package com.vigade.pizzeriabackend.application;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import lombok.Getter;
import lombok.Setter;

@Validated
@Getter @Setter
public class IngredientDTOInput {
    @NotBlank
    private String name;
    @NotNull
    private float price;
}
