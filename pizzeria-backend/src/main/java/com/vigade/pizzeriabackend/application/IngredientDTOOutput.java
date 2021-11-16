package com.vigade.pizzeriabackend.application;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientDTOOutput {
    private UUID id;
    private String name;
    private float price;
}
