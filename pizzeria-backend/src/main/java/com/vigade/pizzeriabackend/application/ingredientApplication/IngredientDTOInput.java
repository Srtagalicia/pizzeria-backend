package com.vigade.pizzeriabackend.application.ingredientApplication;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
public @Getter @Setter class IngredientDTOInput {
    
    @NotBlank(message="name is mandatory") @Size(min=2, max=45)
    private String name;

    @NotNull(message="price is mandatory") @Digits(integer=3, fraction=2) @DecimalMin(value="0.0", inclusive=false)
    private BigDecimal price;
}