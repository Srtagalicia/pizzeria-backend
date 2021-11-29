package com.vigade.pizzeriabackend.application.ingredientApplication;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class IngredientDTOOutput {
    private UUID id;
    private String name;
    private BigDecimal price;
}