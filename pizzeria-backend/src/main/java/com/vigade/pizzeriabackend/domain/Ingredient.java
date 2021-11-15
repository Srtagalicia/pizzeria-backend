package com.vigade.pizzeriabackend.domain;

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
