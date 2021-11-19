package com.vigade.pizzeriabackend.application.ingredientApplication;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class IngredientDTOInput {
    private String name;
    private BigDecimal price;
}
