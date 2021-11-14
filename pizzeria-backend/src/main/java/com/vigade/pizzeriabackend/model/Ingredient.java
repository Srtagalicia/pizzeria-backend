package com.vigade.pizzeriabackend.model;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Getter
    @Setter
    private int ingredientId;
    @Getter
    @Setter
    private String name;

    

}
